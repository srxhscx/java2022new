package com.example.demo.menu;
import com.example.demo.accountManagement.accountManagementMain;
import com.example.demo.business.businessmain;
import com.example.demo.carType.carTypeMain;
import com.example.demo.citymanagement.citymanagementMain;
import com.example.demo.dao.*;
import com.example.demo.good.goodmain;
import com.example.demo.transportationPlanGeneration.transportationPlanGenerationMain;
import com.example.demo.vo.*;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class MenuController implements Initializable{

    //初始化函数
    //显示TableView表格数据

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //添加数据, 这些数据可以从数据库中查询出
        //业务类型管理
        BuisnessDAO buisnessDAO = new BuisnessDAO();
        Iterator<Buisness> businessiter = buisnessDAO.getBusiness().iterator();
        //int num=0;

        //AtomicInteger finalNum = new AtomicInteger(0);
        int i = 0;
        while(businessiter.hasNext())
        {
            //finalNum.getAndIncrement() ;
            businessdata.add(businessiter.next());
            StringProperty businessstate = buisnessDAO.getBusiness().get(i).business_stateProperty();
           // System.out.println(buisnessDAO.getBusiness().get(i).business_stateProperty());


            int finalI = i;
            businessOperate.setCellFactory((col)->{

                TableCell<Buisness, String> businesscell = new TableCell<Buisness, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if(businessstate.getValue().equals("正常") ){
                            Button button1 = new Button("停用");
                            button1.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                            button1.setOnMouseClicked((col) -> {
                                //获取list列表中的位置，进而获取列表对应的信息数据
                                // Buisness buisness = list.get(getIndex());
                                //按钮事件自己添加


                                //buisnessDAO.updateBusinessState(  buisnessDAO.getBusiness().get().getBusiness_id());
                                System.out.println(finalI);
                                System.out.println("修改成功");
                                //buisnessDAO.getBusiness().get(finalNum.get()).getBusiness_id()
                            });
                            if (empty) {
                                //如果此列为空默认不添加元素
                                setText(null);
                                setGraphic(null);
                            } else {
                                this.setGraphic(button1);
                            }
                        }

                    }
                };
                        return businesscell;
            }
            );
            i++;
        }


        //货物管理
        GoodsDAO goodsDAO = new GoodsDAO();
        Iterator<Goods> goodsiter = goodsDAO.getGoods().iterator();
        int i2 = 0;
        StringProperty goodstate = buisnessDAO.getBusiness().get(i2).business_stateProperty();

        while(goodsiter.hasNext()) {
          goodsdata.add(goodsiter.next());
            goodOperator.setCellFactory((col)->{

                        TableCell<Goods, String> goodcell = new TableCell<Goods, String>()
                        {
                            @Override
                            protected void updateItem(String item, boolean empty)
                            {
                                super.updateItem(item, empty);
                                if(goodstate.getValue().equals("正常") ){
                                    Button button1 = new Button("停用");
                                    button1.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                                    button1.setOnMouseClicked((col) -> {


                                        //buisnessDAO.updateBusinessState(  buisnessDAO.getBusiness().get().getBusiness_id());
                                        //System.out.println(finalI);
                                        System.out.println("修改成功");
                                        //buisnessDAO.getBusiness().get(finalNum.get()).getBusiness_id()
                                    });
                                    if (empty) {
                                        //如果此列为空默认不添加元素
                                        setText(null);
                                        setGraphic(null);
                                    } else {
                                        this.setGraphic(button1);
                                    }
                                }

                            }
                        };
                        return goodcell;
                    }
            );
       }
        //货物管理的ComboBOX
        goodsNameCB.getItems().addAll(
                "3C",
                "图书",
                "日百",
                "服装",
                "食品"
        );
        //数据源为空时显示
        goodsNameCB.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        goodsNameCB.setEditable(true);
        goodsNameCB.setPromptText("选择货物名称");
        //设置可见行数, 超过显示滚动条
        goodsNameCB.setVisibleRowCount(5);


        //accountManagement
        accountManagementDAO accountManagementdao = new accountManagementDAO();
        Iterator<accountManagement> iteram= accountManagementdao.getAccountManagement().iterator();
        while(iteram.hasNext()) {
            accountManagementdata.add(iteram.next());
        }

        //车型管理
        CarTypeDAO cartypeDao = new CarTypeDAO();
        Iterator<Cartype> cartypeIteratoriter = cartypeDao.getCartype().iterator();
        int i3 = 0;
        StringProperty cartypeState = cartypeDao.getCartype().get(i3).car_stateProperty();

        while(cartypeIteratoriter.hasNext()) {
            cartypedata.add(cartypeIteratoriter.next());
            carTypeOperator.setCellFactory((col)->{

                        TableCell<Cartype, String> Cartypecell = new TableCell<Cartype, String>()
                        {
                            @Override
                            protected void updateItem(String item, boolean empty)
                            {
                                super.updateItem(item, empty);
                                if(cartypeState.getValue().equals("正常") ){
                                    Button button1 = new Button("停用");
                                    button1.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                                    button1.setOnMouseClicked((col) -> {


                                        //buisnessDAO.updateBusinessState(  buisnessDAO.getBusiness().get().getBusiness_id());
                                        //System.out.println(finalI);
                                        System.out.println("修改成功");
                                        //buisnessDAO.getBusiness().get(finalNum.get()).getBusiness_id()
                                    });
                                    if (empty) {
                                        //如果此列为空默认不添加元素
                                        setText(null);
                                        setGraphic(null);
                                    } else {
                                        this.setGraphic(button1);
                                    }
                                }

                            }
                        };
                        return Cartypecell;
                    }
            );
        }
        //货物管理的ComboBOX
        CarTypeCB.getItems().addAll(
                "7米2",
                "9米6",
                "5米8",
                "6米9"

        );
        //数据源为空时显示
        CarTypeCB.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        CarTypeCB.setEditable(true);
        CarTypeCB.setPromptText("选择车型");
        //设置可见行数, 超过显示滚动条
        CarTypeCB.setVisibleRowCount(5);

        //城市管理
        city_nodeDAO city_nodeDAO = new city_nodeDAO();
        Iterator<CityNode> citynodeiter = city_nodeDAO.getCityNode().iterator();
        //int num=0;

        //AtomicInteger finalNum = new AtomicInteger(0);
        int i4 = 0;
        while(citynodeiter.hasNext())
        {
            //finalNum.getAndIncrement() ;
            citynodedata.add(citynodeiter.next());
            StringProperty citynodestate = city_nodeDAO.getCityNode().get(i4).city_stateProperty();
            // System.out.println(buisnessDAO.getBusiness().get(i).business_stateProperty());


            int finalI = i;
            citynodeOperator.setCellFactory((col)->{

                        TableCell<CityNode, String> citynodecell = new TableCell<CityNode, String>()
                        {
                            @Override
                            protected void updateItem(String item, boolean empty)
                            {
                                super.updateItem(item, empty);
                                if(citynodestate.getValue().equals("正常") ){
                                    Button button1 = new Button("停用");
                                    button1.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                                    button1.setOnMouseClicked((col) -> {
                                        //获取list列表中的位置，进而获取列表对应的信息数据
                                        // Buisness buisness = list.get(getIndex());
                                        //按钮事件自己添加


                                        //buisnessDAO.updateBusinessState(  buisnessDAO.getBusiness().get().getBusiness_id());
                                        System.out.println(finalI);
                                        System.out.println("修改成功");
                                        //buisnessDAO.getBusiness().get(finalNum.get()).getBusiness_id()
                                    });
                                    if (empty) {
                                        //如果此列为空默认不添加元素
                                        setText(null);
                                        setGraphic(null);
                                    } else {
                                        this.setGraphic(button1);
                                    }
                                }

                            }
                        };
                        return citynodecell;
                    }
            );
            i++;
        }

        //运输计划
        TransportationPlanGenerationDAO transportationPlanGenerationDAO = new TransportationPlanGenerationDAO();
        Iterator<TransportationPlanGeneration> transportationPlanGeneratoriter = transportationPlanGenerationDAO.getTransportationPlanGeneration().iterator();
        while(transportationPlanGeneratoriter.hasNext()) {
            transportationPlanGenerationdata.add(transportationPlanGeneratoriter.next());
        }


        //设置每列的数据
        //设置业务类型管理数据
        businessState.setCellValueFactory(cellData-> cellData.getValue().business_stateProperty());
        businessType.setCellValueFactory( cellData-> cellData.getValue().business_typeProperty());
        businessDistribution.setCellValueFactory( cellData-> cellData.getValue().business_distributionProperty());
        businessRemark.setCellValueFactory( cellData-> cellData.getValue().business_remarkProperty());


        //设置货物管理数据
        goodState.setCellValueFactory(cellData-> cellData.getValue().good_stateProperty());
        goodName.setCellValueFactory(cellData-> cellData.getValue().good_nameProperty());
        goodRemark.setCellValueFactory(cellData-> cellData.getValue().good_remarkProperty());

        //设置accountManagement
        amaccount.setCellValueFactory(cellData-> cellData.getValue().am_accountProperty());
        amname.setCellValueFactory( cellData-> cellData.getValue().am_nameProperty());
        aminstitution.setCellValueFactory( cellData-> cellData.getValue().am_institutionProperty());
        amcity.setCellValueFactory( cellData-> cellData.getValue().am_cityProperty());
        amnode.setCellValueFactory( cellData-> cellData.getValue().am_nodeProperty());
        amtel.setCellValueFactory( cellData-> cellData.getValue().am_contactProperty());
        ammail.setCellValueFactory( cellData-> cellData.getValue().am_mailProperty());


        //设置车型管理数据
        carType.setCellValueFactory(cellData-> cellData.getValue().car_typeProperty());
        carTypeState.setCellValueFactory(cellData-> cellData.getValue().car_stateProperty());
        carTypeVolume.setCellValueFactory(cellData-> cellData.getValue().car_volumeProperty());
        carTypeLoad.setCellValueFactory(cellData-> cellData.getValue().car_volumeProperty());
        carTypeRemark.setCellValueFactory(cellData-> cellData.getValue().car_remarkProperty());
        //carTypeOperator.setCellValueFactory(cellData-> cellData.getValue().ca);

        //设置城市管理数据
        //citynodeOperator.setCellValueFactory(cellData-> cellData.getValue().city_stateProperty());
        citynodeState.setCellValueFactory(cellData-> cellData.getValue().city_stateProperty());
        citynodeId.setCellValueFactory(cellData-> cellData.getValue().city_idProperty());
        citynodename.setCellValueFactory(cellData-> cellData.getValue().city_nameProperty());
        citynodeinstitution.setCellValueFactory(cellData-> cellData.getValue().city_institutionProperty());
        citynodedistribution.setCellValueFactory(cellData-> cellData.getValue().city_distributionProperty());


        //设置运输计划
        transportationPlanGenerationState.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_stateProperty());
        transportationPlanGenerationType.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_typeProperty());
        transportationPlanGenerationFromCity.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_from_cityProperty());
        transportationPlanGenerationToCity.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_to_cityProperty());
        transportationPlanGenerationFromBase.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_from_baseProperty());
        transportationPlanGenerationToBase.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_to_baseProperty());
        transportationPlanGenerationNumber.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_numberProperty());
        transportationPlanGenerationVolume.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_volumeProperty());
        transportationPlanGenerationWeight.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_weightProperty());
        transportationPlanGenerationRemark.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_remarkProperty());



        //设置表格数据
        businessTableView.setItems(businessdata);
        GoodsTableView.setItems(goodsdata);
        amtableView.setItems(accountManagementdata);
        CarTypeTableView.setItems(cartypedata);
        citynodeTableView.setItems(citynodedata);
        TPGTableView.setItems(transportationPlanGenerationdata);


    }
    /**
     * 业务类型管理
     */
    @FXML
    private Button businesscheckBtn;
    @FXML
    private TextField businessText;
    @FXML
    private TableColumn<Buisness, String> businessDistribution;
    @FXML
    private TableColumn<Buisness, String> businessOperate;
    @FXML
    private TableColumn<Buisness, String> businessType;
    @FXML
    private TableColumn<Buisness, String> businessRemark;
    @FXML
    private TableColumn<Buisness,String> businessState;
    //查询按钮
    @FXML
    void businesscheck(ActionEvent event) {
        String typeText = this.businessText.getText();
        if(typeText == null || typeText.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }
        else{
            businessTableView.getItems().clear();
        }

        //添加数据, 这些数据从数据库中查询出
        BuisnessDAO buisnessDAO = new BuisnessDAO();

        Iterator<Buisness> iter = buisnessDAO.getBusinessByBusinessType(typeText).iterator();
        while(iter.hasNext()) {
            businessdata.add(iter.next());
        }

        //设置每列的数据
        goodState.setCellValueFactory(cellData-> cellData.getValue().good_stateProperty());
        goodName.setCellValueFactory(cellData-> cellData.getValue().good_nameProperty());
        goodRemark.setCellValueFactory(cellData-> cellData.getValue().good_remarkProperty());

        //设置表格数据
        businessTableView.setItems(businessdata);

    }
    @FXML
    //创建TableView
    private TableView<Buisness> businessTableView = new TableView<>();
    //创建数据集合
    private ObservableList<Buisness> businessdata = FXCollections.observableArrayList();
    @FXML
    private Button buildBusinessBtn;
    //新建业务类型的按钮
    @FXML
    void buildBusiness(ActionEvent event) {
        //businessmain business = new businessmain();
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) buildBusinessBtn.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new businessmain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }


    /**
     * 货物管理
     */
    @FXML
    private Button goodsCheckBtn;
    @FXML
    private TableView<Goods> GoodsTableView = new TableView<>();
    //创建数据集合
    private ObservableList<Goods> goodsdata = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> goodsNameCB;

    @FXML
    private TableColumn<Goods,String> goodRemark;
    @FXML
    private TableColumn<Goods, String> goodName;
    @FXML
    private TableColumn<Goods, String> goodState;

    @FXML
    private TableColumn<Goods, String> goodOperator;
    @FXML
    private Button addGoodsBtn;


    @FXML
    void addGoods(ActionEvent event) {
        //businessmain business = new businessmain();
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) addGoodsBtn.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new goodmain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    @FXML
    void goodsCheck(ActionEvent event) {
        String goodName1 = this.goodsNameCB.getValue().toString();
        if(goodName1 == null || goodName1.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }
        else{
            GoodsTableView.getItems().clear();
        }

        //添加数据, 这些数据从数据库中查询出
        GoodsDAO goodsDAO = new GoodsDAO();

        Iterator<Goods> goodsiter = goodsDAO.getGoodsBygoodName(goodName1).iterator();
        while(goodsiter.hasNext()) {
            goodsdata.add(goodsiter.next());
        }

        //设置每列的数据
        goodState.setCellValueFactory(cellData-> cellData.getValue().good_stateProperty());
        goodName.setCellValueFactory(cellData-> cellData.getValue().good_nameProperty());
        goodRemark.setCellValueFactory(cellData-> cellData.getValue().good_remarkProperty());

        //设置表格数据
        GoodsTableView.setItems(goodsdata);
    }


    /**
     * accountManagement
     */

    @FXML
    private TableColumn<accountManagement,String> amstate;
    @FXML
    private TableColumn<accountManagement,String> amaccount;
    @FXML
    private TableColumn<accountManagement,String> amname;
    @FXML
    private TableColumn<accountManagement,String> aminstitution;
    @FXML
    private TableColumn<accountManagement,String> amcity;
    @FXML
    private TableColumn<accountManagement,String> amnode;
    @FXML
    private TableColumn<accountManagement,String> amtel;
    @FXML
    private TableColumn<accountManagement,String> ammail;
    @FXML
    private TableColumn<accountManagement,String> amremark;
    @FXML
    private TableColumn<accountManagement,String> amoperate;

    @FXML
    //创建TableView
    private TableView<accountManagement> amtableView = new TableView<>();
    //创建数据集合
    private ObservableList<accountManagement> accountManagementdata = FXCollections.observableArrayList();

    @FXML
    private Button amnewaccount;
    @FXML
    void newAccountChecked(ActionEvent event){
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) amnewaccount.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new accountManagementMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    /**
     * 车型管理
     */
    @FXML
    private Button cartypeBtn;
    @FXML
    private ComboBox<String> CarTypeCB;
    @FXML
    private Button buildCarType;

    @FXML
    private TableView<Cartype> CarTypeTableView = new TableView<>();
    //创建数据集合
    private ObservableList<Cartype> cartypedata = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Cartype, String> carType;
    @FXML
    private TableColumn<Cartype, String> carTypeOperator;
    @FXML
    private TableColumn<Cartype, String> carTypeLoad;
    @FXML
    private TableColumn<Cartype, String> carTypeState;
    @FXML
    private TableColumn<Cartype, String> carTypeVolume;
    @FXML
    private TableColumn<Cartype, String> carTypeRemark;


    @FXML
    void buildcartype(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) buildCarType.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new carTypeMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    @FXML
    void cartypeCheck(ActionEvent event) {
        String carType1 = this.CarTypeCB.getValue().toString();
        if(carType1 == null || carType1.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }

        else{
            CarTypeTableView.getItems().clear();
        }

        //添加数据, 这些数据从数据库中查询出
        CarTypeDAO carTypeDAO = new CarTypeDAO();

        Iterator<Cartype> cartypesiter = carTypeDAO.getCarTypeBycarType(carType1).iterator();
        while(cartypesiter.hasNext()) {
            cartypedata.add(cartypesiter.next());
        }

       // carType.setCellValueFactory(cellData-> cellData.getValue().car_typeProperty());
        carTypeState.setCellValueFactory(cellData-> cellData.getValue().car_stateProperty());
        carTypeVolume.setCellValueFactory(cellData-> cellData.getValue().car_volumeProperty());
        carTypeLoad.setCellValueFactory(cellData-> cellData.getValue().car_volumeProperty());
        carTypeRemark.setCellValueFactory(cellData-> cellData.getValue().car_remarkProperty());

        //设置表格数据
        CarTypeTableView.setItems(cartypedata);
    }

    /**
    * 城市管理
    */
    @FXML
    private Button citynodeCheckBtn;
    @FXML
    private Button citynodeBuildBtn;
    @FXML
    private TextField citynameText;

    @FXML
    private TableView<CityNode> citynodeTableView = new TableView<>();

    //创建数据集合
    private ObservableList<CityNode> citynodedata = FXCollections.observableArrayList();
    @FXML
    private TableColumn<CityNode, String> citynodename;
    @FXML
    private TableColumn<CityNode, String> citynodeState;
    @FXML
    private TableColumn<CityNode, String> citynodeId;
    @FXML
    private TableColumn<CityNode, String> citynodedistribution;
    @FXML
    private TableColumn<CityNode, String> citynodeOperator;
    @FXML
    private TableColumn<CityNode, String> citynodeinstitution;
    @FXML
    void citynodeCheck(ActionEvent event) {
        String cityname1 = this.citynameText.getText();
       // System.out.println(cityname1);
        if(cityname1 == null || cityname1.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }

        else{
            citynodeTableView.getItems().clear();
        }

        //添加数据, 这些数据从数据库中查询出
        city_nodeDAO city_nodeDAO1 = new city_nodeDAO();

        Iterator<CityNode> cityNodeIterator1 = city_nodeDAO1.getCitynodeBycityName(cityname1).iterator();
        while(cityNodeIterator1.hasNext()) {
            citynodedata.add(cityNodeIterator1.next());

        }

        //设置城市管理数据
        //citynodeOperator.setCellValueFactory(cellData-> cellData.getValue().city_stateProperty());
        citynodeState.setCellValueFactory(cellData-> cellData.getValue().city_stateProperty());
        citynodeId.setCellValueFactory(cellData-> cellData.getValue().city_idProperty());
        citynodename.setCellValueFactory(cellData-> cellData.getValue().city_nameProperty());
        citynodeinstitution.setCellValueFactory(cellData-> cellData.getValue().city_institutionProperty());
        citynodedistribution.setCellValueFactory(cellData-> cellData.getValue().city_distributionProperty());


        //设置表格数据
        citynodeTableView.setItems(citynodedata);
    }

    @FXML
    void citynodeBuild(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) citynodeBuildBtn.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new citymanagementMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    /**
     * 发运管理——运输计划生成
     */
    @FXML
    private ChoiceBox TPGType;
    @FXML
    private TableColumn<TransportationPlanGeneration, String> transportationPlanGenerationState;
    @FXML
    private TableColumn<TransportationPlanGeneration, String> transportationPlanGenerationType;
    @FXML
    private TableColumn<TransportationPlanGeneration, String> transportationPlanGenerationFromCity;
    @FXML
    private TableColumn<TransportationPlanGeneration, String> transportationPlanGenerationToCity;
    @FXML
    private TableColumn<TransportationPlanGeneration, String> transportationPlanGenerationFromBase;
    @FXML
    private TableColumn<TransportationPlanGeneration, String> transportationPlanGenerationToBase;
    @FXML
    private TableColumn<TransportationPlanGeneration, String> transportationPlanGenerationNumber;
    @FXML
    private TableColumn<TransportationPlanGeneration, String> transportationPlanGenerationVolume;
    @FXML
    private TableColumn<TransportationPlanGeneration, String> transportationPlanGenerationWeight;
    @FXML
    private TableColumn<TransportationPlanGeneration, String> transportationPlanGenerationRemark;
    @FXML
    private TableColumn<TransportationPlanGeneration, String> transportationPlanGenerationOperation;


    //查询按钮
    @FXML
    private Button checkTPGBtn;
    @FXML
    void checkTPG(ActionEvent event) {
        String typeText = this.TPGType.getValue().toString();
        if(typeText == null || typeText.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }
        else{
            TPGTableView.getItems().clear();
        }

        //添加数据, 这些数据从数据库中查询出
        TransportationPlanGenerationDAO transportationPlanGenerationDAO = new TransportationPlanGenerationDAO();

        Iterator<TransportationPlanGeneration> iter1 = transportationPlanGenerationDAO.getTransportationPlanGenerationByTransportationPlanGenerationType(typeText).iterator();
        while(iter1.hasNext()) {
            transportationPlanGenerationdata.add(iter1.next());
        }

        //设置每列的数据

        transportationPlanGenerationState.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_stateProperty());
        transportationPlanGenerationType.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_typeProperty());
        transportationPlanGenerationFromCity.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_from_cityProperty());
        transportationPlanGenerationToCity.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_to_cityProperty());
        transportationPlanGenerationFromBase.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_from_baseProperty());
        transportationPlanGenerationToBase.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_to_baseProperty());
        transportationPlanGenerationNumber.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_numberProperty());
        transportationPlanGenerationVolume.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_volumeProperty());
        transportationPlanGenerationWeight.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_weightProperty());
        transportationPlanGenerationRemark.setCellValueFactory(cellData-> cellData.getValue().transportationPlanGeneration_remarkProperty());

        //设置表格数据
        TPGTableView.setItems(transportationPlanGenerationdata);

    }
    @FXML
    //创建TableView
    private TableView<TransportationPlanGeneration> TPGTableView = new TableView<>();
    //创建数据集合
    private ObservableList<TransportationPlanGeneration> transportationPlanGenerationdata = FXCollections.observableArrayList();
    @FXML
    private Button buildTPGBtn;
    //新建业务类型的按钮
    @FXML
    void buildTPG(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) buildTPGBtn.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new transportationPlanGenerationMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }


}
