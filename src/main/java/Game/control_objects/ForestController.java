package Game.control_objects;

import Game.Game;
import Game.game_events.Fight;
import Game.game_events.SignEvent;
import Game.game_objects.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Controller class for the forest_window fxml file
 */
public class ForestController implements Initializable {
    //variables
    private static Logger logger = LoggerFactory.getLogger(ForestController.class);
    private static Player player;
    private int incr = 2;
    private boolean isset = false;
    private boolean tpready = false;
    private boolean can_move = true;
    private boolean is_sign_event = false;
    private Bear bear;
    private Fight fight = new Fight();
    private SignEvent signevent = new SignEvent();
    private XmlMethods xml_methods = new XmlMethods();
    private CityController cityController = new CityController();
    private Inventory inv = new Inventory(player);
    private Images images = new Images();


    //declaring the tree objects
    private TreeObject tree, tree1, tree2, tree3, tree4, tree5, tree6, tree7, tree8, tree9, tree10, tree11, tree12, tree13, tree14, tree15, tree16;
    private TreeObject tree17, tree18, tree19, tree20, tree21, tree22, tree23, tree24, tree25, tree26, tree27, tree28, tree29, tree30, tree31, tree32, tree33;
    private TreeObject tree34, tree35, tree36, tree37, tree38, tree39, tree40, tree41, tree42, tree43, tree44, tree45, tree46, tree47, tree48, tree49, tree50, tree51, tree52, tree53;
    private TreeObject tree54, tree55, tree56, tree57, tree58, tree59, tree60, tree61, tree62, tree63, tree64, tree65, tree66, tree67;


    //fxml variables
    @FXML
    private static String playername = "playername";
    @FXML
    private Label playername_label = new Label(playername);
    @FXML
    private Label score_label = new Label();
    @FXML
    private Label text_pane_text;
    @FXML
    private Label option1, option2, option3, option4;

    @FXML
    Pane root = new Pane();
    @FXML
    private static AnchorPane entity_pane = new AnchorPane();
    @FXML
    private AnchorPane inventory;
    @FXML
    private Label dagger_desc, note_desc;

    @FXML
    private AnchorPane text_pane;


    //fxml_figs
    @FXML
    private ImageView player_fig;
    @FXML
    private ImageView tree_fig;
    @FXML
    private ImageView dagger_fig;
    @FXML
    private ImageView dagger_fig_inv;
    @FXML
    private ImageView note_fig;
    @FXML
    private ImageView note_fig_inv;
    @FXML
    private ImageView bear_fig;
    @FXML
    private ImageView tree_fig1;
    @FXML
    private ImageView tree_fig2;
    @FXML
    private ImageView tree_fig3;
    @FXML
    private ImageView tree_fig4;
    @FXML
    private ImageView tree_fig5;
    @FXML
    private ImageView tree_fig6;
    @FXML
    private ImageView tree_fig7;
    @FXML
    private ImageView tree_fig8;
    @FXML
    private ImageView tree_fig9;
    @FXML
    private ImageView tree_fig10;
    @FXML
    private ImageView tree_fig11;
    @FXML
    private ImageView tree_fig12;
    @FXML
    private ImageView tree_fig13;
    @FXML
    private ImageView tree_fig14;
    @FXML
    private ImageView tree_fig15;
    @FXML
    private ImageView tree_fig16;
    @FXML
    private ImageView tree_fig17;
    @FXML
    private ImageView tree_fig18;
    @FXML
    private ImageView tree_fig19;
    @FXML
    private ImageView tree_fig20;
    @FXML
    private ImageView tree_fig21;
    @FXML
    private ImageView tree_fig22;
    @FXML
    private ImageView tree_fig23;
    @FXML
    private ImageView tree_fig24;
    @FXML
    private ImageView tree_fig25;
    @FXML
    private ImageView tree_fig26;
    @FXML
    private ImageView tree_fig27;
    @FXML
    private ImageView tree_fig28;
    @FXML
    private ImageView tree_fig29;
    @FXML
    private ImageView tree_fig30;
    @FXML
    private ImageView tree_fig31;
    @FXML
    private ImageView tree_fig32;
    @FXML
    private ImageView tree_fig33;
    @FXML
    private ImageView tree_fig34;
    @FXML
    private ImageView tree_fig35;
    @FXML
    private ImageView tree_fig36;
    @FXML
    private ImageView tree_fig37;
    @FXML
    private ImageView tree_fig38;
    @FXML
    private ImageView tree_fig39;
    @FXML
    private ImageView tree_fig40;
    @FXML
    private ImageView tree_fig41;
    @FXML
    private ImageView tree_fig42;
    @FXML
    private ImageView tree_fig43;
    @FXML
    private ImageView tree_fig44;
    @FXML
    private ImageView tree_fig45;
    @FXML
    private ImageView tree_fig46;
    @FXML
    private ImageView tree_fig47;
    @FXML
    private ImageView tree_fig48;
    @FXML
    private ImageView tree_fig49;
    @FXML
    private ImageView tree_fig50;
    @FXML
    private ImageView tree_fig51;
    @FXML
    private ImageView tree_fig52;
    @FXML
    private ImageView tree_fig53;
    @FXML
    private ImageView tree_fig54;
    @FXML
    private ImageView tree_fig55;
    @FXML
    private ImageView tree_fig56;
    @FXML
    private ImageView tree_fig57;
    @FXML
    private ImageView tree_fig58;
    @FXML
    private ImageView tree_fig59;
    @FXML
    private ImageView tree_fig60;
    @FXML
    private ImageView tree_fig61;
    @FXML
    private ImageView tree_fig62;
    @FXML
    private ImageView tree_fig63;
    @FXML
    private ImageView tree_fig64;
    @FXML
    private ImageView tree_fig65;
    @FXML
    private ImageView tree_fig66;
    @FXML
    private ImageView tree_fig67;

    /**
     * default constructor for the class
     */
    public ForestController() throws MalformedURLException {
    }


    //fxml methods

    /**
     * method that uses the <code>XmlMethods</code> class as its base to save the playerdata into the xml file
     *
     * @throws FileNotFoundException
     * @throws JAXBException
     */
    @FXML
    private void save() throws FileNotFoundException, JAXBException {
        xml_methods.save(player);
    }

    /**
     * method that uses the <code>XmlMethods</code> class as its base to load the playerdata from the xml file
     *
     * @throws JAXBException
     */
    @FXML
    public void load() throws JAXBException, FileNotFoundException {
        Player loadplayer = xml_methods.load();
        logger.trace(loadplayer.getName());
        setname();
        isset = true;
        if (loadplayer.getgender().equals("male")) {
            setpic();
        }
        if (loadplayer.getFought()) {
            bear_fig.setVisible(false);
        }
        player = loadplayer;
        player_fig.setLayoutX(player.getPosx());
        player_fig.setLayoutY(player.getPosy());
        score_label.setText(String.valueOf(player.getscore()));
        isThere();
    }

    @FXML
    private void option1_clicked() throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException, MalformedURLException {
        option1();
    }

    @FXML
    private void option2_clicked() throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException, MalformedURLException {
        option2();
    }

    @FXML
    private void option3_clicked() throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException, MalformedURLException {
        option3();
    }

    @FXML
    private void option4_clicked() throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException, MalformedURLException {
        option4();
    }

    @FXML
    private void label_on_hover_in1() {
        option1.setStyle("-fx-background-color:black;-fx-text-fill: green");
    }

    @FXML
    private void label_on_hover_out1() {
        option1.setStyle("-fx-background-color:gray;-fx-text-fill: black");
    }

    @FXML
    private void label_on_hover_in2() {
        option2.setStyle("-fx-background-color:black;-fx-text-fill: green");
    }

    @FXML
    private void label_on_hover_out2() {
        option2.setStyle("-fx-background-color:gray;-fx-text-fill: black");
    }

    @FXML
    private void label_on_hover_in3() {
        option3.setStyle("-fx-background-color:black;-fx-text-fill: green");
    }

    @FXML
    private void label_on_hover_out3() {
        option3.setStyle("-fx-background-color:gray;-fx-text-fill: black");
    }

    @FXML
    private void label_on_hover_in4() {
        option4.setStyle("-fx-background-color:black;-fx-text-fill: green");
    }

    @FXML
    private void label_on_hover_out4() {
        option4.setStyle("-fx-background-color:gray;-fx-text-fill: black");
    }


    /**
     * writes the name and gender of the player into the game
     */
    @FXML
    private void setname() {
        if (isset == false) {
            playername_label.setText(playername + ", " + player.getgender());
            isset = true;
        }
    }

    @FXML
    public void setpic() {
        player_fig.setImage(images.getimage());
    }


    //inventory related stuff


    @FXML
    private void open_note_desc() {
        getNote_desc().setVisible(true);
    }

    @FXML
    private void open_dagger_desc() {
        getDagger_desc().setVisible(true);
    }

    @FXML
    private void open_inv() {
        open_inventory();
    }

    @FXML
    private void close_inv() {
        close_inventory();
    }

    public void open_inventory() {
        getInventory().setVisible(true);

        if (player.getItems().size() == 0) {
        } else if (player.getItems().size() > 1) {
            logger.info("slot id 0: " + inv.getslot(0) + ", slot id 1: " + inv.getslot(1));

            if ((player.getitem(0).getid() == 0 && player.getitem(1).getid() == 1) ||
                    (player.getitem(0).getid() == 1 && player.getitem(1).getid() == 0)) {
                getDagger_fig_inv().setVisible(true);
                getNote_fig_inv().setVisible(true);
                getDagger_fig().setImage(null);
                getNote_fig().setImage(null);
            }
        } else if (player.getItems().size() == 1) {
            logger.info("slot id 0: " + inv.getslot(0));
            if (player.getitem(0).getid() == 1) {
                getNote_fig().setImage(null);
                getNote_fig_inv().setVisible(true);
            } else if (player.getitem(0).getid() == 0) {
                getDagger_fig().setImage(null);
                getDagger_fig_inv().setVisible(true);
            }
        }
    }

    public void close_inventory() {
        getInventory().setVisible(false);
        getNote_desc().setVisible(false);
        getDagger_desc().setVisible(false);
    }


    /**
     * method to set the main Scene's player to this scene
     *
     * @param player2 player object from the Game class
     */
    public void setPlayer(Player player2) {
        player = player2;
        playername = player.getName();
        playername_label.setText(playername + ", " + player.getgender());
        boolean isok = true;
    }

    /**
     * a constructor for TreeObject objects, that uses the getTree function as its return value
     *
     * @param x    x coords of the tree object
     * @param y    y coords of the tree object
     * @param tree the image of the object
     * @return the created temp_tree TreeObject
     */
    public TreeObject settrees(int x, int y, ImageView tree) {
        TreeObject temp_tree = new TreeObject(x, y, tree, entity_pane);
        return getTree(temp_tree);
    }

    /**
     * method that raises the player's score and then saves the data into the xml
     *
     * @throws FileNotFoundException
     * @throws JAXBException
     */
    public void raiseScore() throws FileNotFoundException, JAXBException {
        player.setscore(player.getscore() + 10);
        score_label.setText(String.valueOf(player.getscore()));
        save();
    }

    /**
     * method that gets called when the player collides with an item, then calls the raiseScore and isThere methods
     *
     * @throws FileNotFoundException
     * @throws JAXBException
     */
    public void setcollided() throws FileNotFoundException, JAXBException {
        raiseScore();
        isThere();
    }

    /**
     * method that checks if the player's itemlist contains the items on the map, and if it does, makes the items disappear
     */
    private void isThere() {

        if (player.getItems().isEmpty()) {
            return;
        }
        if (player.getItems().size() == 1) {
            if (player.getitem(0).getid() == 0) {
                inv.setslot(0, 0);
                dagger_fig.setImage(null);
                dagger_fig.setDisable(true);
            } else if (player.getitem(0).getid() == 1) {
                inv.setslot(0, 1);
                note_fig.setImage(null);
                note_fig.setDisable(true);
            }
        } else if (
                (player.getitem(0).getid() == 0 && player.getitem(1).getid() == 1) ||
                        (player.getitem(0).getid() == 1 && player.getitem(1).getid() == 0)
        ) {
            note_fig.setImage(null);
            note_fig.setDisable(true);
            dagger_fig.setImage(null);
            dagger_fig.setDisable(true);
            if (player.getitem(0).getid() == 0 && player.getitem(1).getid() == 1) {
                inv.setslot(1, 1);
            } else if (player.getitem(0).getid() == 1 && player.getitem(1).getid() == 0) {
                inv.setslot(1, 0);
            }
        }
    }


    /**
     * method to initialize trees
     */
    public void inittrees() {
        tree = settrees((int) tree_fig.getLayoutX(), (int) tree_fig.getLayoutY(), tree_fig);
        tree1 = settrees((int) tree_fig1.getLayoutX(), (int) tree_fig1.getLayoutY(), tree_fig1);
        tree2 = settrees((int) tree_fig2.getLayoutX(), (int) tree_fig2.getLayoutY(), tree_fig2);
        tree3 = settrees((int) tree_fig3.getLayoutX(), (int) tree_fig3.getLayoutY(), tree_fig3);
        tree4 = settrees((int) tree_fig4.getLayoutX(), (int) tree_fig4.getLayoutY(), tree_fig4);
        tree5 = settrees((int) tree_fig5.getLayoutX(), (int) tree_fig5.getLayoutY(), tree_fig5);
        tree6 = settrees((int) tree_fig6.getLayoutX(), (int) tree_fig6.getLayoutY(), tree_fig6);
        tree7 = settrees((int) tree_fig7.getLayoutX(), (int) tree_fig7.getLayoutY(), tree_fig7);
        tree8 = settrees((int) tree_fig8.getLayoutX(), (int) tree_fig8.getLayoutY(), tree_fig8);
        tree9 = settrees((int) tree_fig9.getLayoutX(), (int) tree_fig9.getLayoutY(), tree_fig9);
        tree10 = settrees((int) tree_fig10.getLayoutX(), (int) tree_fig10.getLayoutY(), tree_fig10);
        tree11 = settrees((int) tree_fig11.getLayoutX(), (int) tree_fig11.getLayoutY(), tree_fig11);
        tree12 = settrees((int) tree_fig12.getLayoutX(), (int) tree_fig12.getLayoutY(), tree_fig12);
        tree13 = settrees((int) tree_fig13.getLayoutX(), (int) tree_fig13.getLayoutY(), tree_fig13);
        tree14 = settrees((int) tree_fig14.getLayoutX(), (int) tree_fig14.getLayoutY(), tree_fig14);
        tree15 = settrees((int) tree_fig15.getLayoutX(), (int) tree_fig15.getLayoutY(), tree_fig15);
        tree16 = settrees((int) tree_fig16.getLayoutX(), (int) tree_fig16.getLayoutY(), tree_fig16);
        tree17 = settrees((int) tree_fig17.getLayoutX(), (int) tree_fig17.getLayoutY(), tree_fig17);
        tree18 = settrees((int) tree_fig18.getLayoutX(), (int) tree_fig18.getLayoutY(), tree_fig18);
        tree19 = settrees((int) tree_fig19.getLayoutX(), (int) tree_fig19.getLayoutY(), tree_fig19);
        tree20 = settrees((int) tree_fig20.getLayoutX(), (int) tree_fig20.getLayoutY(), tree_fig20);
        tree21 = settrees((int) tree_fig21.getLayoutX(), (int) tree_fig21.getLayoutY(), tree_fig21);
        tree22 = settrees((int) tree_fig22.getLayoutX(), (int) tree_fig22.getLayoutY(), tree_fig22);
        tree23 = settrees((int) tree_fig23.getLayoutX(), (int) tree_fig23.getLayoutY(), tree_fig23);
        tree24 = settrees((int) tree_fig24.getLayoutX(), (int) tree_fig24.getLayoutY(), tree_fig24);
        tree25 = settrees((int) tree_fig25.getLayoutX(), (int) tree_fig25.getLayoutY(), tree_fig25);
        tree26 = settrees((int) tree_fig26.getLayoutX(), (int) tree_fig26.getLayoutY(), tree_fig26);
        tree27 = settrees((int) tree_fig27.getLayoutX(), (int) tree_fig27.getLayoutY(), tree_fig27);
        tree28 = settrees((int) tree_fig28.getLayoutX(), (int) tree_fig28.getLayoutY(), tree_fig28);
        tree29 = settrees((int) tree_fig29.getLayoutX(), (int) tree_fig29.getLayoutY(), tree_fig29);
        tree30 = settrees((int) tree_fig30.getLayoutX(), (int) tree_fig30.getLayoutY(), tree_fig30);
        tree31 = settrees((int) tree_fig31.getLayoutX(), (int) tree_fig31.getLayoutY(), tree_fig31);
        tree32 = settrees((int) tree_fig32.getLayoutX(), (int) tree_fig32.getLayoutY(), tree_fig32);
        tree33 = settrees((int) tree_fig33.getLayoutX(), (int) tree_fig33.getLayoutY(), tree_fig33);
        tree34 = settrees((int) tree_fig34.getLayoutX(), (int) tree_fig34.getLayoutY(), tree_fig34);
        tree35 = settrees((int) tree_fig35.getLayoutX(), (int) tree_fig35.getLayoutY(), tree_fig35);
        tree36 = settrees((int) tree_fig36.getLayoutX(), (int) tree_fig36.getLayoutY(), tree_fig36);
        tree37 = settrees((int) tree_fig37.getLayoutX(), (int) tree_fig37.getLayoutY(), tree_fig37);
        tree38 = settrees((int) tree_fig38.getLayoutX(), (int) tree_fig38.getLayoutY(), tree_fig38);
        tree39 = settrees((int) tree_fig39.getLayoutX(), (int) tree_fig39.getLayoutY(), tree_fig39);
        tree40 = settrees((int) tree_fig40.getLayoutX(), (int) tree_fig40.getLayoutY(), tree_fig40);
        tree41 = settrees((int) tree_fig41.getLayoutX(), (int) tree_fig41.getLayoutY(), tree_fig41);
        tree42 = settrees((int) tree_fig42.getLayoutX(), (int) tree_fig42.getLayoutY(), tree_fig42);
        tree43 = settrees((int) tree_fig43.getLayoutX(), (int) tree_fig43.getLayoutY(), tree_fig43);
        tree44 = settrees((int) tree_fig44.getLayoutX(), (int) tree_fig44.getLayoutY(), tree_fig44);
        tree45 = settrees((int) tree_fig45.getLayoutX(), (int) tree_fig45.getLayoutY(), tree_fig45);
        tree46 = settrees((int) tree_fig46.getLayoutX(), (int) tree_fig46.getLayoutY(), tree_fig46);
        tree47 = settrees((int) tree_fig47.getLayoutX(), (int) tree_fig47.getLayoutY(), tree_fig47);
        tree48 = settrees((int) tree_fig48.getLayoutX(), (int) tree_fig48.getLayoutY(), tree_fig48);
        tree49 = settrees((int) tree_fig49.getLayoutX(), (int) tree_fig49.getLayoutY(), tree_fig49);
        tree50 = settrees((int) tree_fig50.getLayoutX(), (int) tree_fig50.getLayoutY(), tree_fig50);
        tree51 = settrees((int) tree_fig51.getLayoutX(), (int) tree_fig51.getLayoutY(), tree_fig51);
        tree52 = settrees((int) tree_fig52.getLayoutX(), (int) tree_fig52.getLayoutY(), tree_fig52);
        tree53 = settrees((int) tree_fig53.getLayoutX(), (int) tree_fig53.getLayoutY(), tree_fig53);
        tree54 = settrees((int) tree_fig54.getLayoutX(), (int) tree_fig54.getLayoutY(), tree_fig54);
        tree55 = settrees((int) tree_fig55.getLayoutX(), (int) tree_fig55.getLayoutY(), tree_fig55);
        tree56 = settrees((int) tree_fig56.getLayoutX(), (int) tree_fig56.getLayoutY(), tree_fig56);
        tree57 = settrees((int) tree_fig57.getLayoutX(), (int) tree_fig57.getLayoutY(), tree_fig57);
        tree58 = settrees((int) tree_fig58.getLayoutX(), (int) tree_fig58.getLayoutY(), tree_fig58);
        tree59 = settrees((int) tree_fig59.getLayoutX(), (int) tree_fig59.getLayoutY(), tree_fig59);
        tree60 = settrees((int) tree_fig60.getLayoutX(), (int) tree_fig60.getLayoutY(), tree_fig60);
        tree61 = settrees((int) tree_fig61.getLayoutX(), (int) tree_fig61.getLayoutY(), tree_fig61);
        tree62 = settrees((int) tree_fig62.getLayoutX(), (int) tree_fig62.getLayoutY(), tree_fig62);
        tree63 = settrees((int) tree_fig63.getLayoutX(), (int) tree_fig63.getLayoutY(), tree_fig63);
        tree64 = settrees((int) tree_fig64.getLayoutX(), (int) tree_fig64.getLayoutY(), tree_fig64);
        tree65 = settrees((int) tree_fig65.getLayoutX(), (int) tree_fig65.getLayoutY(), tree_fig65);
        tree66 = settrees((int) tree_fig66.getLayoutX(), (int) tree_fig66.getLayoutY(), tree_fig66);
        tree67 = settrees((int) tree_fig67.getLayoutX(), (int) tree_fig67.getLayoutY(), tree_fig67);
    }


    /**
     * method that deals with the player movement
     */
    private void movement() {
        AtomicBoolean presseda = new AtomicBoolean(false);
        AtomicBoolean pressedw = new AtomicBoolean(false);
        AtomicBoolean presseds = new AtomicBoolean(false);
        AtomicBoolean pressedd = new AtomicBoolean(false);

        root.setOnKeyPressed(e -> {
            if (can_move == true) {
                if (presseda.get() == false && pressedw.get() == false && presseds.get() == false && pressedd.get() == false) {
                    if (e.getCode() == KeyCode.A) {
                        presseda.set(true);
                        player.setLastx(player.getPosx());
                        player.setLasty(player.getPosy());
                        player.setPosx(player.getPosx() - incr);
                        player_fig.setLayoutX(player.getPosx());

                        //collosion detection
                        //for items
                        try {
                            collosionDetect();
                            is_event_over();
                        } catch (CollosionException | URISyntaxException | FileNotFoundException | JAXBException | MalformedURLException error) {
                            logger.error("error occured: ", error);
                        }

                    }
                    if (e.getCode() == KeyCode.D) {
                        pressedd.set(true);
                        player.setLastx(player.getPosx());
                        player.setLasty(player.getPosy());
                        player.setPosx(player.getPosx() + incr);
                        player_fig.setLayoutX(player.getPosx());

                        //collosion detection
                        //for items
                        try {
                            collosionDetect();
                            is_event_over();
                        } catch (CollosionException | URISyntaxException | FileNotFoundException | JAXBException | MalformedURLException error) {
                            logger.error("error occured: ", error);
                        }
                    }
                    if (e.getCode() == KeyCode.W) {
                        pressedw.set(true);
                        player.setLastx(player.getPosx());
                        player.setLasty(player.getPosy());
                        player.setPosy(player.getPosy() - incr);
                        player_fig.setLayoutY(player.getPosy());

                        //collosion detection
                        //for items
                        try {
                            collosionDetect();
                            is_event_over();
                        } catch (CollosionException | FileNotFoundException | JAXBException | URISyntaxException | MalformedURLException er) {
                            logger.error("error occured: ", er);
                        }
                    }
                    if (e.getCode() == KeyCode.S) {
                        presseds.set(true);
                        player.setLastx(player.getPosx());
                        player.setLasty(player.getPosy());
                        player.setPosy(player.getPosy() + incr);
                        player_fig.setLayoutY(player.getPosy());

                        //collosion detection
                        //for items
                        try {
                            collosionDetect();
                            is_event_over();
                        } catch (CollosionException | URISyntaxException | FileNotFoundException | JAXBException | MalformedURLException er) {
                            logger.error("error occured: ", er);
                        }
                    }

                } else if (presseda.get() == true || pressedw.get() == true || presseds.get() == true || pressedd.get() == true) {

                    if (presseda.get() == true) {
                        if (e.getCode() == KeyCode.A) {
                            player.setLastx(player.getPosx());
                            player.setLasty(player.getPosy());
                            player.setPosx(player.getPosx() - incr);
                            player_fig.setLayoutX(player.getPosx());

                            //collosion detection
                            //for items
                            try {
                                collosionDetect();
                                is_event_over();
                            } catch (CollosionException | URISyntaxException | FileNotFoundException | JAXBException | MalformedURLException error) {
                                logger.error("error occured: ", error);
                            }

                        }
                        if (e.getCode() == KeyCode.W) {
                            player.setLastx(player.getPosx());
                            player.setLasty(player.getPosy());
                            player.setPosy(player.getPosy() - incr);
                            player_fig.setLayoutY(player.getPosy());
                            player.setPosx(player.getPosx() - incr);
                            player_fig.setLayoutX(player.getPosx());

                            //collosion detection
                            //for items
                            try {
                                collosionDetect();
                                is_event_over();
                            } catch (CollosionException | FileNotFoundException | JAXBException | URISyntaxException | MalformedURLException er) {
                                logger.error("error occured: ", er);
                            }
                        }
                        if (e.getCode() == KeyCode.S) {
                            player.setLastx(player.getPosx());
                            player.setLasty(player.getPosy());
                            player.setPosy(player.getPosy() + incr);
                            player_fig.setLayoutY(player.getPosy());
                            player.setPosx(player.getPosx() - incr);
                            player_fig.setLayoutX(player.getPosx());

                            //collosion detection
                            //for items
                            try {
                                collosionDetect();
                                is_event_over();
                            } catch (CollosionException | URISyntaxException | FileNotFoundException | JAXBException | MalformedURLException er) {
                                logger.error("error occured: ", er);
                            }
                        }

                    } else if (pressedw.get() == true) {
                        if (e.getCode() == KeyCode.W) {
                            player.setLastx(player.getPosx());
                            player.setLasty(player.getPosy());
                            player.setPosy(player.getPosy() - incr);
                            player_fig.setLayoutY(player.getPosy());

                            //collosion detection
                            //for items
                            try {
                                collosionDetect();
                                is_event_over();
                            } catch (CollosionException | FileNotFoundException | JAXBException | URISyntaxException | MalformedURLException er) {
                                logger.error("error occured: ", er);
                            }
                        }
                        if (e.getCode() == KeyCode.A) {
                            player.setLastx(player.getPosx());
                            player.setLasty(player.getPosy());
                            player.setPosx(player.getPosx() - incr);
                            player_fig.setLayoutX(player.getPosx());
                            player.setPosy(player.getPosy() - incr);
                            player_fig.setLayoutY(player.getPosy());

                            //collosion detection
                            //for items
                            try {
                                collosionDetect();
                                is_event_over();
                            } catch (CollosionException | URISyntaxException | FileNotFoundException | JAXBException | MalformedURLException error) {
                                logger.error("error occured: ", error);
                            }

                        }
                        if (e.getCode() == KeyCode.D) {
                            player.setLastx(player.getPosx());
                            player.setLasty(player.getPosy());
                            player.setPosx(player.getPosx() + incr);
                            player_fig.setLayoutX(player.getPosx());
                            player.setPosy(player.getPosy() - incr);
                            player_fig.setLayoutY(player.getPosy());

                            //collosion detection
                            //for items
                            try {
                                collosionDetect();
                                is_event_over();
                            } catch (CollosionException | URISyntaxException | FileNotFoundException | JAXBException | MalformedURLException error) {
                                logger.error("error occured: ", error);
                            }
                        }
                    } else if (presseds.get() == true) {
                        if (e.getCode() == KeyCode.S) {
                            player.setLastx(player.getPosx());
                            player.setLasty(player.getPosy());
                            player.setPosy(player.getPosy() + incr);
                            player_fig.setLayoutY(player.getPosy());

                            //collosion detection
                            //for items
                            try {
                                collosionDetect();
                                is_event_over();
                            } catch (CollosionException | FileNotFoundException | JAXBException | URISyntaxException | MalformedURLException er) {
                                logger.error("error occured: ", er);
                            }
                        }
                        if (e.getCode() == KeyCode.A) {
                            player.setLastx(player.getPosx());
                            player.setLasty(player.getPosy());
                            player.setPosx(player.getPosx() - incr);
                            player_fig.setLayoutX(player.getPosx());
                            player.setPosy(player.getPosy() + incr);
                            player_fig.setLayoutY(player.getPosy());

                            //collosion detection
                            //for items
                            try {
                                collosionDetect();
                                is_event_over();
                            } catch (CollosionException | URISyntaxException | FileNotFoundException | JAXBException | MalformedURLException error) {
                                logger.error("error occured: ", error);
                            }

                        }
                        if (e.getCode() == KeyCode.D) {
                            player.setLastx(player.getPosx());
                            player.setLasty(player.getPosy());
                            player.setPosx(player.getPosx() + incr);
                            player_fig.setLayoutX(player.getPosx());
                            player.setPosy(player.getPosy() + incr);
                            player_fig.setLayoutY(player.getPosy());

                            //collosion detection
                            //for items
                            try {
                                collosionDetect();
                                is_event_over();
                            } catch (CollosionException | URISyntaxException | FileNotFoundException | JAXBException | MalformedURLException error) {
                                logger.error("error occured: ", error);
                            }
                        }
                    } else if (pressedd.get() == true) {
                        if (e.getCode() == KeyCode.D) {
                            player.setLastx(player.getPosx());
                            player.setLasty(player.getPosy());
                            player.setPosx(player.getPosx() + incr);
                            player_fig.setLayoutX(player.getPosx());

                            //collosion detection
                            //for items
                            try {
                                collosionDetect();
                                is_event_over();
                            } catch (CollosionException | URISyntaxException | FileNotFoundException | JAXBException | MalformedURLException error) {
                                logger.error("error occured: ", error);
                            }

                        }
                        if (e.getCode() == KeyCode.W) {
                            player.setLastx(player.getPosx());
                            player.setLasty(player.getPosy());
                            player.setPosy(player.getPosy() - incr);
                            player_fig.setLayoutY(player.getPosy());
                            player.setPosx(player.getPosx() + incr);
                            player_fig.setLayoutX(player.getPosx());

                            //collosion detection
                            //for items
                            try {
                                collosionDetect();
                                is_event_over();
                            } catch (CollosionException | FileNotFoundException | JAXBException | URISyntaxException | MalformedURLException er) {
                                logger.error("error occured: ", er);
                            }
                        }
                        if (e.getCode() == KeyCode.S) {
                            player.setLastx(player.getPosx());
                            player.setLasty(player.getPosy());
                            player.setPosy(player.getPosy() + incr);
                            player_fig.setLayoutY(player.getPosy());
                            player.setPosx(player.getPosx() + incr);
                            player_fig.setLayoutX(player.getPosx());

                            //collosion detection
                            //for items
                            try {
                                collosionDetect();
                                is_event_over();
                            } catch (CollosionException | URISyntaxException | FileNotFoundException | JAXBException | MalformedURLException er) {
                                logger.error("error occured: ", er);
                            }
                        }
                    }


                }
            }
        });

        root.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.A) {
                presseda.set(false);
            }
            if (e.getCode() == KeyCode.W) {
                pressedw.set(false);
            }
            if (e.getCode() == KeyCode.S) {
                presseds.set(false);
            }
            if (e.getCode() == KeyCode.D) {
                pressedd.set(false);
            }
        });

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //initializing trees
        inittrees();

        //init the bear
        bear = new Bear(730, 314, bear_fig, entity_pane);

        //player movement
        movement();
    }

    /**
     * method that changes the Game class's scene into the CityScene from the ForestScene
     *
     * @throws FileNotFoundException
     * @throws JAXBException
     * @throws URISyntaxException
     */
    private void change_to_city() throws FileNotFoundException, JAXBException, URISyntaxException {
        if (Collosion.Collosion_tp(player)) {
            setTpReady(true);
            if (tpready && player.getFought()) {
                cityController.load_city(Game.getPrimarystage());
            }
        }
    }

    /**
     * method to start the event when the player collides with the sign near the pond.
     */
    private void start_sign_event() {
        if (Collosion.Collosion_sign(player)) {
            if (signevent.Sign_crossroad() == 1) {
                is_sign_event = true;
                setpane();
                set_sign_event();
            }
        }
    }

    private void set_sign_event() {
        setText_pane_text("You see a Sign in front of you just beside a big pond and on it there is a strange drawing, but you\n" +
                " can't work out what it means. But you recognise some fish with teeth from all that.\n" +
                "Suddenly you hear a woman's cry for help, and it seems like it comes from the water in front of you!\n" +
                "You decide to:");
        setOption1("go away,it was just the wind");
        setOption2("try to take a look who it is");
        setOption3("no time to waste, jump in and save her");
        setOption4("yell to make sure you didnt hallucinate");
    }

    private void theSignEvent(int round_counter, int option) throws FileNotFoundException, JAXBException {
        switch (round_counter) {
            case 0:
                setText_pane_text("You decide to yell to her just to make sure you did not hallucinate.\n" +
                        "You do hear her again, but for some reason the sound feels like it comes just beside your ears.");
                setOption1("no time to waste, jump in and save her");
                setOption2("time to go look around");
                setOption3("i have a bad feeling, lets go");
                getOption4().setVisible(false);
                if (option == 1) {
                    fight_lost();
                } else if (option == 2) {
                    fight_lost();
                } else if (option == 3) {
                    fight_lost();
                } else if (option == 4) {
                    raiseScore();
                }
                break;
            case 1:
                if (option == 1) {

                } else if (option == 2) {

                } else if (option == 3) {
                    raiseScore();
                    end_stuff("You decide to walk away.\nWhen you turn around the woman suddenly leaps out of the water, trying to consume you" +
                            "\nShe was a water hag preying on humans.Luckily it was cursed and can't get away from the water.\nA" +
                            " hand appears from the depths and drags the hag back into the pond.");
                }
                break;
        }
    }


    public void option1() throws FileNotFoundException, JAXBException, MalformedURLException {
        if (is_sign_event) {
            theSignEvent(signevent.getcounter(),1);
            signevent.setcounter(signevent.getcounter() + 1);

        } else {
            thefight(fight.getcounter(), 1);
            fight_done(fight.getcounter());
            fight.setcounter(fight.getcounter() + 1);

            if (fight.run) {
                can_move = true;
                end_stuff("you tried to run away, but... running away from a bear is pretty much impossible... you died");
                fight.setcounter(55);
            }
        }

    }

    public void option2() throws FileNotFoundException, JAXBException, MalformedURLException {
        if (is_sign_event) {
            theSignEvent(signevent.getcounter(),2);
            signevent.setcounter(signevent.getcounter() + 1);
        } else {
            thefight(fight.getcounter(), 2);
            fight_done(fight.getcounter());
            fight.setcounter(fight.getcounter() + 1);
        }
    }

    public void option3() throws FileNotFoundException, JAXBException, MalformedURLException {
        if (is_sign_event) {
            theSignEvent(signevent.getcounter(),3);
            signevent.setcounter(signevent.getcounter() + 1);
        } else {
            thefight(fight.getcounter(), 3);
            fight_done(fight.getcounter());
            fight.setcounter(fight.getcounter() + 1);
        }
    }

    public void option4() throws FileNotFoundException, JAXBException, MalformedURLException {
        if (is_sign_event) {
            theSignEvent(signevent.getcounter(),4);
            signevent.setcounter(signevent.getcounter() + 1);
        } else {
            thefight(fight.getcounter(), 4);
            fight_done(fight.getcounter());
            fight.setcounter(fight.getcounter() + 1);
        }
    }

    /**
     * The method makes the buttons invisible and let the player move again.
     * @param str the message to display on the textfield.
     */
    private void end_stuff(String str) {
        setText_pane_text(str);
        get_text_pane().setDisable(false);
        getOption1().setVisible(false);
        getOption2().setVisible(false);
        getOption3().setVisible(false);
        getOption4().setVisible(false);
        can_move = true;
    }


    //start of fight_event stuff


    /**
     * method to check if the player collided with the bear object, and if did opens the <code>fight</code> game event.
     *
     * @throws CollosionException throws when the player and the object is at the exact same pixel coordinate.
     */
    private void start_fight_after_bear_collides() throws CollosionException {
        boolean can_start = Collosion.Collosion_detection(player, bear);
        if (can_start == false) {

            if (fight.Fight_crossroad(player) == -1) {
                no_weapon();
            } else if (fight.Fight_crossroad(player) == 0) {
                setpane();
                start_fight();
            } else if (fight.Fight_crossroad(player) == 1) {
            }
        }
    }

    /**
     * method that checks if the fight event with the bear is over
     */
    private void is_event_over() {
        if (is_sign_event){
            if (signevent.getcounter()>0){
                if (text_pane.isVisible()) {
                    text_pane.setVisible(false);
                }
            }
        }
        else {
            if (fight.getcounter() >= 10 && fight.getcounter() < 55) {
                if (text_pane.isVisible()) {
                    text_pane.setVisible(false);
                }
            }
            if (fight.getcounter() > 54) {
                System.exit(0);
            }
        }
    }

    /**
     * gets called when the player is ready to fight(not fought yet and has dagger).
     */
    private void start_fight() {
        setText_pane_text("You see a Bear in front of you sleeping in the grass.\nAs you lurk closer it suddenly snaps its" +
                " eyes open and looks at you.\nYou remember that you found a weapon along the way here... maybe it was " +
                "for this moment.\nThe bear suddenly lets out a horrendous roar and starts running towards you,full of killing intent!");
        setOption1("run away");
        setOption2("try to play dead");
        setOption3("try to talk it out with him");
        setOption4("dodge the rush to the right");
    }

    /**
     * the method gets called when the player wins the fight against the bear.
     * @param counter the fight class's round_counter
     * @throws FileNotFoundException throws if the xml file doesnt exist
     * @throws JAXBException throws if there is an error with the xml file
     */
    private void fight_done(int counter) throws FileNotFoundException, JAXBException {
        if (counter >= 7 && counter < 10) {
            end_stuff("You decide to wait for the bear...It slowly walks towards you, seemingly really weakened...\n" +
                    "As it reaches you, it lifts up its paws to strike...You prepare for the last strike!\nAnd the bear just falls to the ground, lifeless! You won, go through the city gate now!");
            fight.setcounter(10);
            player.setFought(true);
            save();
        }
    }

    /**
     * method that gets called if the player chooses the wrong option in the fight.
     */
    private void fight_lost() {
        if (fight.getcounter() > 1) {
            end_stuff("You fought hard, but sadly you lost this fight... but you can do it again! Good Luck!");
            fight.setcounter(55);
        } else {
            end_stuff("It wasn't a tough fight i suppose... well... sadly you lost this fight... but you can do it again! Good Luck!");
            fight.setcounter(55);
        }
    }

    /**
     * method to make the text gui appear.
     */
    private void setpane() {
        get_text_pane().setDisable(false);
        get_text_pane().setVisible(true);
        can_move = false;
    }

    /**
     * method that gets called if the player collides with the bear without getting the dagger first.
     */
    public void no_weapon() {
        setpane();
        getOption2().setVisible(false);
        getOption3().setVisible(false);
        getOption4().setVisible(false);
        gettext_pane_text().setText("You found a bear laying in the grass.\n" +
                "When you come closer it suddenly gets up and starts running towards you!\n" +
                "Sadly you have no weapon with you, the best you can do now is run!");
        getOption1().setText("run");
        fight.run = true;
    }


    private void thefight(int round_counter, int option) throws FileNotFoundException, JAXBException, MalformedURLException {
        switch (round_counter) {
            case 0:
                setText_pane_text("You dodged to the side, and just barely survive the rush...\nOn the other hand, the bear" +
                        " seems to be surprised about this.\nit might be your chance to deal some damage to it!");
                setOption1("maybe it is playing, lets wait");
                setOption2("time to stab it in the eye");
                setOption3("try to talk it out with him");
                setOption4("laugh and run away");
                if (option == 1) {
                    fight_lost();
                } else if (option == 2) {
                    fight_lost();
                } else if (option == 3) {
                    fight_lost();
                } else if (option == 4) {
                    raiseScore();
                }
                break;
            case 1:
                setText_pane_text("You decided to grab your chances and thrust your blade into its eyes.\nThe bear probably didn't like " +
                        "it,\nas you succeed in wounding it, he roars and once again rushes towards you!");
                setOption1("lets dodge to the left now!");
                setOption2("what about now...? lets play dead?");
                setOption3("try to talk it out with him");
                setOption4("hmm, dodge to the right again!");
                if (option == 1) {
                    fight_lost();
                } else if (option == 2) {
                    raiseScore();
                } else if (option == 3) {
                    fight_lost();
                } else if (option == 4) {
                    fight_lost();
                }
                break;
            case 2:
                setText_pane_text("You dodge to the left, the bear half expecting your move, lunges to the right\nsadly for him" +
                        " you have chosen the other side... time for another punishment?");
                setOption1("lets play it safe for now...");
                setOption2("Alright!!! lets cut it down!");
                setOption3("maybe i can run away now?");
                setOption4("attack its rear!");
                if (option == 1) {
                    raiseScore();
                } else if (option == 2) {
                    fight_lost();
                } else if (option == 3) {
                    fight_lost();
                } else if (option == 4) {
                    fight_lost();
                }
                break;
            case 3:
                setText_pane_text("You decide to wait, and you have chosen the right option...\n" +
                        "The bear who seemed like an easy prey a moment ago\nsuddenly turns back towards you and slashes with its pawns.");
                setOption1("try to dodge to the left!");
                setOption2("cut down its pawns!");
                setOption3("stand still...");
                setOption4("dodge backwards!");
                if (option == 1) {
                    raiseScore();
                } else if (option == 2) {
                    fight_lost();
                } else if (option == 3) {
                    fight_lost();
                } else if (option == 4) {
                    fight_lost();
                }
                break;
            case 4:
                setText_pane_text("You play the bear into a fool..\nThe bear, expecting you to dodge, turns its body to the left, slashing the air\n" +
                        "maybe now you can get some damage?");
                setOption1("stab your dagger into its head");
                setOption2("try to slash its fore legs!");
                setOption3("grab the chance to run away!");
                setOption4("stab its hind legs.");
                if (option == 1) {
                    fight_lost();
                } else if (option == 2) {
                    fight_lost();
                } else if (option == 3) {
                    raiseScore();
                } else if (option == 4) {
                    fight_lost();
                }
                break;
            case 5:
                setText_pane_text("You stab the beast on its hind legs!\nIt seemingly is a little exhausted now" +
                        " and the wound on its left hindleg is bleeding constantly.\nWhat will you do now?");
                setOption1("Time to give him more wounds!");
                setOption2("Wait for another chance at punishment!");
                setOption3("guess an exhausted bear might not catch me? lets run!");
                setOption4("This time i'll be the one rushing in!");
                if (option == 1) {
                    fight_lost();
                } else if (option == 2) {
                    fight_lost();
                } else if (option == 3) {
                    fight_lost();
                } else if (option == 4) {
                    raiseScore();
                }
                break;
            case 6:
                setText_pane_text("You once again stay patient, just standing still waiting for the bear to make its move.\n" +
                        "It isn't a patient type on the other hand,but only slowly comes towards you...\nThe difficulty just risen!");
                setOption1("Lets wait for any attack!");
                setOption2("He is clearly exhausted, lets go! KILL!!!");
                setOption3("lets slash its other leg as well!");
                setOption4("maybe i can run away now?");
                if (option == 1) {
                    fight_lost();
                } else if (option == 2) {
                    raiseScore();
                } else if (option == 3) {
                    fight_lost();
                } else if (option == 4) {
                    fight_lost();
                }
                break;
            case 7:
                if (option == 1) {
                    raiseScore();
                    fight_done(round_counter);
                } else if (option == 2) {
                    fight_lost();
                } else if (option == 3) {
                    fight_lost();
                } else if (option == 4) {
                    fight_lost();
                }
                break;
        }
    }

    /**
     * method for collosion detection
     *
     * @throws CollosionException
     * @throws FileNotFoundException
     * @throws JAXBException
     * @throws URISyntaxException
     */
    private void collosionDetect() throws CollosionException, FileNotFoundException, JAXBException, URISyntaxException, MalformedURLException {
        //collosion with bear
        start_fight_after_bear_collides();

        //collosion detection between items and player
        Collosion.Collosion_detection_item(this, player);
        start_sign_event();
        change_to_city();

        //collosion detection between trees and player
        Collosion.Collosion_detection(player, getTree(tree));
        Collosion.Collosion_detection(player, getTree(tree1));
        Collosion.Collosion_detection(player, getTree(tree2));
        Collosion.Collosion_detection(player, getTree(tree3));
        Collosion.Collosion_detection(player, getTree(tree4));
        Collosion.Collosion_detection(player, getTree(tree5));
        Collosion.Collosion_detection(player, getTree(tree6));
        Collosion.Collosion_detection(player, getTree(tree7));
        Collosion.Collosion_detection(player, getTree(tree8));
        Collosion.Collosion_detection(player, getTree(tree9));
        Collosion.Collosion_detection(player, getTree(tree10));
        Collosion.Collosion_detection(player, getTree(tree11));
        Collosion.Collosion_detection(player, getTree(tree12));
        Collosion.Collosion_detection(player, getTree(tree13));
        Collosion.Collosion_detection(player, getTree(tree14));
        Collosion.Collosion_detection(player, getTree(tree15));
        Collosion.Collosion_detection(player, getTree(tree16));
        Collosion.Collosion_detection(player, getTree(tree17));
        Collosion.Collosion_detection(player, getTree(tree18));
        Collosion.Collosion_detection(player, getTree(tree19));
        Collosion.Collosion_detection(player, getTree(tree20));
        Collosion.Collosion_detection(player, getTree(tree21));
        Collosion.Collosion_detection(player, getTree(tree22));
        Collosion.Collosion_detection(player, getTree(tree23));
        Collosion.Collosion_detection(player, getTree(tree24));
        Collosion.Collosion_detection(player, getTree(tree25));
        Collosion.Collosion_detection(player, getTree(tree26));
        Collosion.Collosion_detection(player, getTree(tree27));
        Collosion.Collosion_detection(player, getTree(tree28));
        Collosion.Collosion_detection(player, getTree(tree29));
        Collosion.Collosion_detection(player, getTree(tree30));
        Collosion.Collosion_detection(player, getTree(tree31));
        Collosion.Collosion_detection(player, getTree(tree32));
        Collosion.Collosion_detection(player, getTree(tree33));
        Collosion.Collosion_detection(player, getTree(tree34));
        Collosion.Collosion_detection(player, getTree(tree35));
        Collosion.Collosion_detection(player, getTree(tree36));
        Collosion.Collosion_detection(player, getTree(tree37));
        Collosion.Collosion_detection(player, getTree(tree38));
        Collosion.Collosion_detection(player, getTree(tree39));
        Collosion.Collosion_detection(player, getTree(tree40));
        Collosion.Collosion_detection(player, getTree(tree41));
        Collosion.Collosion_detection(player, getTree(tree42));
        Collosion.Collosion_detection(player, getTree(tree43));
        Collosion.Collosion_detection(player, getTree(tree44));
        Collosion.Collosion_detection(player, getTree(tree45));
        Collosion.Collosion_detection(player, getTree(tree46));
        Collosion.Collosion_detection(player, getTree(tree47));
        Collosion.Collosion_detection(player, getTree(tree48));
        Collosion.Collosion_detection(player, getTree(tree49));
        Collosion.Collosion_detection(player, getTree(tree50));
        Collosion.Collosion_detection(player, getTree(tree51));
        Collosion.Collosion_detection(player, getTree(tree52));
        Collosion.Collosion_detection(player, getTree(tree53));
        Collosion.Collosion_detection(player, getTree(tree54));
        Collosion.Collosion_detection(player, getTree(tree55));
        Collosion.Collosion_detection(player, getTree(tree56));
        Collosion.Collosion_detection(player, getTree(tree57));
        Collosion.Collosion_detection(player, getTree(tree58));
        Collosion.Collosion_detection(player, getTree(tree59));
        Collosion.Collosion_detection(player, getTree(tree60));
        Collosion.Collosion_detection(player, getTree(tree61));
        Collosion.Collosion_detection(player, getTree(tree62));
        Collosion.Collosion_detection(player, getTree(tree63));
        Collosion.Collosion_detection(player, getTree(tree64));
        Collosion.Collosion_detection(player, getTree(tree65));
        Collosion.Collosion_detection(player, getTree(tree66));
        Collosion.Collosion_detection(player, getTree(tree67));
    }


    //getters
    public TreeObject getTree(TreeObject tree) {
        return tree;
    }

    public Label gettext_pane_text() {
        return text_pane_text;
    }

    public Label getOption1() {
        return option1;
    }

    public Label getOption2() {
        return option2;
    }

    public Label getOption3() {
        return option3;
    }

    public Label getOption4() {
        return option4;
    }

    public Label getDagger_desc() {
        return dagger_desc;
    }

    public Label getNote_desc() {
        return note_desc;
    }

    public AnchorPane get_text_pane() {
        return text_pane;
    }

    public AnchorPane getInventory() {
        return inventory;
    }

    public ImageView getNote_fig() {
        return note_fig;
    }

    public ImageView getNote_fig_inv() {
        return note_fig_inv;
    }

    public ImageView getDagger_fig() {
        return dagger_fig;
    }

    public ImageView getDagger_fig_inv() {
        return dagger_fig_inv;
    }

    //setters
    public void setText_pane_text(String text) {
        text_pane_text.setText(text);
    }

    public void setOption1(String text) {
        option1.setText("1. " + text);
    }

    public void setOption2(String text) {
        option2.setText("2. " + text);
    }

    public void setOption3(String text) {
        option3.setText("3. " + text);
    }

    public void setOption4(String text) {
        option4.setText("4. " + text);
    }

    public void setTpReady(boolean ready) {
        tpready = ready;
    }

}





