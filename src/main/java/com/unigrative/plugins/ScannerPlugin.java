package com.unigrative.plugins;

import com.evnt.client.common.ClientProperties;
import com.evnt.client.common.EVEManager;
import com.evnt.client.common.EVEManagerUtil;
import com.evnt.common.swing.swingutil.RefreshTitlePanel;
import com.fbi.fbo.impl.dataexport.QueryRow;
import com.fbi.gui.button.FBMainToolbarButton;
import com.fbi.gui.panel.TitlePanel;
import com.fbi.plugins.FishbowlPlugin;
import com.fbi.sdk.constants.MenuGroupNameConst;
import com.unigrative.plugins.panels.clientSettingsPanelImpl;
import com.unigrative.plugins.repository.Repository;
import com.unigrative.plugins.util.property.Property;
import com.unigrative.plugins.util.property.PropertyGetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScannerPlugin extends FishbowlPlugin implements PropertyGetter, Repository.RunSql {
    public static final String MODULE_NAME = "ScannerPlugin"; //CHANGE
    public static final String MODULE_FRIENDLY_NAME = "Scanner Plugin"; //CHANGE
    private static final Logger LOGGER = LoggerFactory.getLogger((Class) ScannerPlugin.class);

    private static final String PLUGIN_GENERIC_PANEL = "pluginGenericPanel";

    public static final String SCANNER_MODULE = "ScannerModule";

    private Repository repository;

    private static ScannerPlugin instance = null;

    EVEManager eveManager = EVEManagerUtil.getEveManager(); //get access to eve manager

    private RefreshTitlePanel titlePanel;
    private JToolBar mainToolBar;
    private FBMainToolbarButton btnSave;

    private JPanel pnlContent;
    //private JPanel pnlGeneric;

    private clientSettingsPanelImpl clientSettingsPanel;

    public ScannerPlugin() {
        instance = this; //this is so we can access the FishbowlPlugin module methods from other classes
        this.setModuleName(ScannerPlugin.MODULE_NAME);
        this.setMenuGroup(MenuGroupNameConst.INTEGRATIONS);//this is the module group it shows up in
        this.setMenuListLocation(1000); //bottom of the list
        this.setIconClassPath("/images/unigrative48.png"); // make sure there is a 24 version in the folder so it can use that for the tabs
        this.setDefaultHelpPath("https://www.unigrative.com/kbtopic/fishbowl-plugins/");

        this.repository = new Repository(this);

    }


    public static ScannerPlugin getInstance() {
        return instance;
    }

    public String getModuleTitle() {
        return "<html><center>Scanner<br>Plugin</center></html>"; //CHANGE -> THIS SHOWS IN THE MODULE LIST
    }

    public String getProperty(final String key) {
        return this.repository.getProperty(key);
    }

    public List<QueryRow> executeSql(final String query) {
        return (List<QueryRow>)this.runQuery(query);
    }


    private void loadSettings() {
        LOGGER.info("Loading Settings");
//        this.txtSqlConnectionUrl.setText(Property.SQL_CONNECTION_URL.get(this));
//        LOGGER.info(Property.SQL_CONNECTION_URL.get(this));
//        this.txtUsername.setText(Property.USERNAME.get(this));
//        this.txtPassword.setText(Encryptor.getInstance().decrypt(Property.PASSWORD.get(this)));
//
//        this.apiKeyTextField.setText(Property.CC_API_KEY.get(this));
//        this.OAuthTokenTextField.setText(Property.CC_TOKEN.get(this));
//        this.txtLastSync.setText(Property.LAST_SYNC_TIME.get(this));
//
//        this.txtCampaignDate.setText(Property.CAMPAIGN_CREATED_DATE.get(this));

        LOGGER.info("Settings Loaded");

    }

    protected void saveSettings(){
        LOGGER.info("Saving settings");

        //client settings
        if (this.clientSettingsPanel.getCboSelectedValue() != null) {
            ClientProperties.setProperty(SCANNER_MODULE, this.clientSettingsPanel.getCboSelectedValue());
            ClientProperties.saveProperties();
        }


        //plugin settings
        final Map<String, String> properties = new HashMap<>();

        properties.put(Property.DEBUG_MODE.getKey(), this.clientSettingsPanel.getDebugModeValue().toString());
//        properties.put(Property.PASSWORD.getKey(), Encryptor.getInstance().encrypt(txtPassword.getText()));
//        properties.put(Property.SQL_CONNECTION_URL.getKey(), txtSqlConnectionUrl.getText());
//
//        properties.put(Property.CC_API_KEY.getKey(), apiKeyTextField.getText());
//        properties.put(Property.CC_TOKEN.getKey(), OAuthTokenTextField.getText());
//
//
//        String lastSync = "";
//        DateTimeFormatter format = ISODateTimeFormat.dateHourMinuteSecond();
//        try {
//
//            lastSync = format.print(format.parseDateTime(txtLastSync.getText())); //set in settings
//        }
//        catch (Exception e){
//            LOGGER.error("Unable to parse Last Sync Time", e);
//            UtilGui.showMessageDialog("Unable to parse Last Sync time");
//            return; //dont save
//        }
//
//        properties.put(Property.LAST_SYNC_TIME.getKey(), lastSync);
//
//
//        String campaignDate = "";
//        try {
//            campaignDate = format.print(format.parseDateTime(txtCampaignDate.getText())); //set in settings
//
//        }
//        catch (Exception e){
//            LOGGER.error("Unable to parse campaign date", e);
//            UtilGui.showMessageDialog("Unable to parse campaign date");
//            return; //dont save
//        }
//
//        properties.put(Property.CAMPAIGN_CREATED_DATE.getKey(), campaignDate);
//


        this.savePluginProperties(properties);

        LOGGER.info("Settings Saved");
    }

    private void btnSaveActionPerformed() {
        this.saveSettings();

    }

    protected void initModule() {
        super.initModule();
        this.initComponents(); //HAS TO COME FIRST SINCE THE PANELS NEED TO BE MADE
        this.setMainToolBar(this.mainToolBar);
        this.initLayout();
        this.setButtonPrintVisible(false); //OPTIONAL
        this.setButtonEmailVisible(false); //OPTIONAL


    }

    private void initLayout() {
        this.pnlContent.add(clientSettingsPanel, "Center");

        String selectedModule = ClientProperties.getProperty(SCANNER_MODULE, null);
        LOGGER.debug("Selected cbobox module = " + selectedModule);

        //todo:add listener to the module visible and reset the value in case it was changed but not saved
        if (selectedModule != null) {
            this.clientSettingsPanel.setCboSelectedValue(selectedModule);
        }
//        String debugMode = getProperty("DebugMode");
//        if (debugMode != null){
//            this.clientSettingsPanel.setChkDebugModeValue(Boolean.valueOf(debugMode));
//        }
//        else{
//            this.clientSettingsPanel.setChkDebugModeValue(false);
//        }


//        this.pnlCards.add(pnlGeneric, "GenericPanel" );
        // this.hideShowPanels();
    }

//    private void hideShowPanels() {
//        final CardLayout layout = (CardLayout)this.pnlCards.getLayout();
//        this.enableControls(true);
//        layout.show(this.pnlCards, PLUGIN_GENERIC_PANEL);
//    }

    private void enableControls(final boolean enable) {
        this.btnSave.setEnabled(enable);
    }

    private void initComponents() {
        try {
            this.titlePanel = new RefreshTitlePanel();

            this.mainToolBar = new JToolBar();
            this.btnSave = new FBMainToolbarButton();

            //GENERIC PANEL
            //this.pnlGeneric  = new JPanel();
            this.clientSettingsPanel = new clientSettingsPanelImpl();

            this.mainToolBar.setFloatable(false);
            this.mainToolBar.setRollover(true);
            this.mainToolBar.setName("mainToolBar");

            this.btnSave.setIcon((Icon) new ImageIcon(this.getClass().getResource("/toolbar/save24.png")));
            this.btnSave.setText("Save");
            this.btnSave.setToolTipText("Save your Scanner Plugin settings."); //CHANGE NAME
            this.btnSave.setHorizontalTextPosition(0);
            this.btnSave.setIconTextGap(0);
            this.btnSave.setMargin(new Insets(0, 2, 0, 2));
            this.btnSave.setName("btnSave");
            this.btnSave.setVerticalTextPosition(3);
            this.btnSave.addActionListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    ScannerPlugin.this.btnSaveActionPerformed();
                }
            });
            this.mainToolBar.add((Component) this.btnSave);

//HEADER LABEL AT THE TOP OF THE MODULE
            this.setName("this");
            this.setLayout(new BorderLayout());
            this.titlePanel.setModuleIcon(new ImageIcon(this.getClass().getResource("/images/unigrative32.png"))); //CHANGE
            this.titlePanel.setModuleTitle(this.MODULE_FRIENDLY_NAME);
            this.titlePanel.setBackground(new Color(44, 94, 140));
            this.titlePanel.setName("pnlTitle");
            this.add(titlePanel, "North");



            this.pnlContent = new JPanel(); //Tabbed layout Option
            this.pnlContent.setName("pnlContent");
            this.pnlContent.setLayout(new BorderLayout());
            this.add(this.pnlContent, "Center");
        }
        catch (Exception e){
            LOGGER.error("Error in init",e);
        }
        LOGGER.info("init done");
    }

}
