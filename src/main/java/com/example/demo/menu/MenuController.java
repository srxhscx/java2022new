package com.example.demo.menu;
import com.example.demo.accountManagement.accountManagementMain;
import com.example.demo.business.businessmain;
import com.example.demo.carType.carTypeMain;
import com.example.demo.dao.BuisnessDAO;
import com.example.demo.dao.CarTypeDAO;
import com.example.demo.dao.GoodsDAO;
import com.example.demo.dao.accountManagementDAO;
import com.example.demo.good.goodmain;
import com.example.demo.vo.Buisness;
import com.example.demo.vo.Cartype;
import com.example.demo.vo.Goods;
import com.example.demo.vo.accountManagement;
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


        //设置表格数据
        businessTableView.setItems(businessdata);
        GoodsTableView.setItems(goodsdata);
        amtableView.setItems(accountManagementdata);
        CarTypeTableView.setItems(cartypedata);


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

}
