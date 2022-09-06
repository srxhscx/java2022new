package com.example.demo.menu;
import com.example.demo.accountManagement.accountManagementMain;
import com.example.demo.business.businessmain;
import com.example.demo.carRecord.carRecordMain;
import com.example.demo.carType.carTypeMain;
import com.example.demo.carrierManagement.carrierManagementMain;
import com.example.demo.characterManagement.characterManagementMain;
import com.example.demo.citymanagement.citymanagementMain;
import com.example.demo.commissionedByFee.commissionedByFeeMain;
import com.example.demo.commissionedByTransport.commissionedByTransportMain;
import com.example.demo.dao.*;
import com.example.demo.freightManagement.freightManagementMain;
import com.example.demo.good.goodmain;
import com.example.demo.newSignInDoc.newSignInDocMain;
import com.example.demo.node.nodeMain;
import com.example.demo.routeManagement.routeManagementMain;
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
import java.util.Timer;
import java.util.TimerTask;

import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class MenuController implements Initializable{

    //初始化函数
    //显示TableView表格数据

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TPGType.getItems().addAll(
                "内配发货",
                "采配发货",
                "贵品发货",
                "奢侈品发货",
                "图书退货",
                "非图书退货",
                "耗材",
                "行政物资"
        );
        commissionedByTransportChoice.getItems().addAll(
                "内配发货",
                "采配发货",
                "贵品发货",
                "奢侈品发货",
                "图书退货",
                "非图书退货",
                "耗材",
                "行政物资"
        );


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
            //i++;
            StringProperty citynodestate1 = city_nodeDAO.getCityNode().get(i4).city_stateProperty();
           // System.out.println(buisnessDAO.getBusiness().get(i).business_stateProperty());

            nodeOperator.setCellFactory((col)->{

                        TableCell<CityNode, String> citynodecell1 = new TableCell<CityNode, String>()
                        {
                            @Override
                            protected void updateItem(String item, boolean empty)
                            {
                                super.updateItem(item, empty);
                                if(citynodestate1.getValue().equals("正常") ){
                                    Button button2 = new Button("停用");
                                    button2.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                                    button2.setOnMouseClicked((col) -> {
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
                                        this.setGraphic(button2);
                                    }
                                }

                            }
                        };
                        return citynodecell1;
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
        //到货管理
        newSignInDocDAO newSignInDocdao = new newSignInDocDAO();
        Iterator<newSignInDoc> newSignInDocDAOiter = newSignInDocdao.getNewSignInDoc().iterator();
        while(newSignInDocDAOiter.hasNext()) {
            newSignInDocdate.add(newSignInDocDAOiter.next());
        }

        //车辆备案
        carRecordDAO carTypeDAO1 = new carRecordDAO();
        Iterator<CarRecord> carRecordIterator = carTypeDAO1.getCarRecord().iterator();
        int i5 = 0;
        StringProperty carRecordState = carTypeDAO1.getCarRecord().get(i5).car_stateProperty();

        while(carRecordIterator.hasNext()) {
            carRecordsdata.add(carRecordIterator.next());
            carrecordOperator.setCellFactory((col)->{

                        TableCell<CarRecord, String> Carrecordcell = new TableCell<CarRecord, String>()
                        {
                            @Override
                            protected void updateItem(String item, boolean empty)
                            {
                                super.updateItem(item, empty);
                                if(carRecordState.getValue().equals("正常") ){
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
                        return Carrecordcell;
                    }
            );
        }
        //车辆备案的ComboBOX
        carrecordPeopleCB.getItems().addAll(
                "中国第一汽车集团公司",
                "大众汽车公司",
                "中国长安汽车集团股份有限公司",
                "奇瑞汽车股份有限公司",
                "北京现代汽车有限公司",
                "东风汽车公司"

        );
        //数据源为空时显示
        carrecordPeopleCB.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        carrecordPeopleCB.setEditable(true);
        carrecordPeopleCB.setPromptText("选择承运商");
        //设置可见行数, 超过显示滚动条
        carrecordPeopleCB.setVisibleRowCount(5);

        //characterManagement
        characterManagementDAO characterManagementdao = new characterManagementDAO();
        Iterator<characterManagement> cmiter = characterManagementdao.getCharacterManagement().iterator();
        while(cmiter.hasNext()) {
           cmdata.add(cmiter.next());
        }

        //节点管理
        while(citynodeiter.hasNext()) {
            //finalNum.getAndIncrement() ;
            citynodedata.add(citynodeiter.next());
        }
        //货物管理的ComboBOX
        CityCB.getItems().addAll(
                "北京",
                "沈阳",
                "长沙",
                "上海",
                "长春","哈尔滨","呼和浩特","天津","石家庄","济南","西安","兰州","武汉","南京","广州","深圳","南京"

        );
        //数据源为空时显示
        CityCB.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        CityCB.setEditable(true);
        CityCB.setPromptText("选择所在城市");
        //设置可见行数, 超过显示滚动条
        CityCB.setVisibleRowCount(7);
        //carrierManagement
        carrierManagementDAO carrierManagementdao = new carrierManagementDAO();
        Iterator<carrierManagement> criter = carrierManagementdao.getCarrierManagement().iterator();
        while(criter.hasNext()) {
            crdata.add(criter.next());
        }

        //routeManagement
        routeManagmentDAO routemanagementdao = new routeManagmentDAO();
        Iterator<routeManagement> rmiter = routemanagementdao.getRouteManagement().iterator();
        while(rmiter.hasNext()) {
            rmdata.add(rmiter.next());
        }

        //freightManagement
        freightManagementDAO freightmanagementdao = new freightManagementDAO();
        Iterator<freightManagement> friter = freightmanagementdao.getFreightManagement().iterator();
        while(friter.hasNext()) {
            frdata.add(friter.next());
        }
        //账单调整
        FeeDAO feeDAO = new FeeDAO();
        Iterator<Fee> feeIterator = feeDAO.getFee().iterator();
        while(feeIterator.hasNext()) {
            feedata.add(feeIterator.next());
        }

        //设置运输委托
        commissionedByTransportNumber.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_numberProperty());
        commissionedByTransportType.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_typeProperty());
        commissionedByTransportCarrier.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_carrierProperty());
        commissionedByTransportWay.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_wayProperty());
        commissionedByTransportFromPeo.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_from_peoProperty());
        commissionedByTransportToPeo.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_to_peoProperty());
        commissionedByTransportRemark.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_remarkProperty());

        //设置在途信息录入
        preInformationNumber.setCellValueFactory(cellData-> cellData.getValue().preInformation_numberProperty());
        preInformationState.setCellValueFactory(cellData-> cellData.getValue().preInformation_stateProperty());
        preInformationLicense.setCellValueFactory(cellData-> cellData.getValue().preInformation_licenseProperty());
        preInformationOnWay.setCellValueFactory(cellData-> cellData.getValue().preInformation_on_wayProperty());
        preInformationCarrier.setCellValueFactory(cellData-> cellData.getValue().preInformation_carrierProperty());

        //设置在途监控
        informationNumber.setCellValueFactory(cellData-> cellData.getValue().information_numberProperty());
        informationState.setCellValueFactory(cellData-> cellData.getValue().information_stateProperty());
        informationLicense.setCellValueFactory(cellData-> cellData.getValue().information_licenseProperty());
        informationOnWay.setCellValueFactory(cellData-> cellData.getValue().information_on_wayProperty());
        informationCarrier.setCellValueFactory(cellData-> cellData.getValue().information_carrierProperty());


        //到货管理
        goodgetnub.setCellValueFactory(cellData-> cellData.getValue().goodget_nubProperty());
        goodgetfcity.setCellValueFactory(cellData-> cellData.getValue().goodget_fcityProperty());
        goodgetfhouse.setCellValueFactory(cellData-> cellData.getValue().goodget_fhouseProperty());
        goodgetlcity.setCellValueFactory(cellData-> cellData.getValue().goodget_lcityProperty());
        goodgetlhouse.setCellValueFactory(cellData-> cellData.getValue().goodget_lhouseProperty());
        goodgetgoodarea.setCellValueFactory(cellData-> cellData.getValue().goodget_goodareaProperty());
        goodgetgetarea.setCellValueFactory(cellData-> cellData.getValue().goodget_getareaProperty());
        goodgetpeople.setCellValueFactory(cellData-> cellData.getValue().goodget_peopleProperty());
        goodgetrunway.setCellValueFactory(cellData-> cellData.getValue().goodget_runwayProperty());
        goodgettype.setCellValueFactory(cellData-> cellData.getValue().goodget_typeProperty());
        goodgetgoodmuch.setCellValueFactory(cellData-> cellData.getValue().goodget_goodmuchProperty());
        goodgetwrite.setCellValueFactory(cellData-> cellData.getValue().goodget_writeProperty());
        goodgetaction.setCellValueFactory(cellData-> cellData.getValue().goodget_actionProperty());

        //设置账单调整
        feeBooknode.setCellValueFactory(cellData-> cellData.getValue().fee_booknodeProperty());
        feeTransnode.setCellValueFactory(cellData-> cellData.getValue().fee_transnodeProperty());
        feeSubprimemoney.setCellValueFactory(cellData-> cellData.getValue().fee_subprimemoneyProperty());
        feeLatemoney.setCellValueFactory(cellData-> cellData.getValue().fee_latemoneyProperty());
        feeOthermoney.setCellValueFactory(cellData-> cellData.getValue().fee_othermoneyProperty());
        feeWhyothermoney.setCellValueFactory(cellData-> cellData.getValue().fee_whyothermoneyProperty());







        //运输委托
        commissionedByTransportDAO commissionedByTransportationDAO = new commissionedByTransportDAO();
        Iterator<CommissionedByTransport> commissionedByTransportior = commissionedByTransportationDAO.getCommissionedByTransport().iterator();
        while(commissionedByTransportior.hasNext()) {
            commissionedByTransportdata.add(commissionedByTransportior.next());
        }

        //在途监控
        TransitMonitorDAO transitMonitor = new TransitMonitorDAO();
        Iterator<TransitMonitor> transitMonitorier = transitMonitor.getTransitMonitor().iterator();
        while(transitMonitorier.hasNext()) {
            transitMonitordata.add(transitMonitorier.next());
        }
        //在途信息录入
        PreTransitMonitorDAO preTransitMonitor = new PreTransitMonitorDAO();
        Iterator<PreTransitMonitor> preTransitMonitorier = preTransitMonitor.getPreTransitMonitor().iterator();
        while(preTransitMonitorier.hasNext()) {
            preTransitMonitordata.add(preTransitMonitorier.next());
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

        //设置车辆备案数据
        carrecordState.setCellValueFactory(cellData-> cellData.getValue().car_stateProperty());
        carrecordRemark.setCellValueFactory(cellData-> cellData.getValue().car_remarkProperty());
        carrecordCartype.setCellValueFactory(cellData-> cellData.getValue().car_typeProperty());
        carrecordCarrier.setCellValueFactory(cellData-> cellData.getValue().car_carrierProperty());
        carrecordPeople.setCellValueFactory(cellData-> cellData.getValue().car_peopleProperty());
        carrecordLoad.setCellValueFactory(cellData-> cellData.getValue().car_loadProperty());
        carrecordNumber1.setCellValueFactory(cellData-> cellData.getValue().car_numberProperty());
        carrecordNumber2.setCellValueFactory(cellData-> cellData.getValue().trailer_numberProperty());
        carrecordTel.setCellValueFactory(cellData-> cellData.getValue().car_telephoneProperty());
        carrecordVolume.setCellValueFactory(cellData-> cellData.getValue().car_volumeProperty());

        //set characterManagement
        cmrole.setCellValueFactory(cellData-> cellData.getValue(). cmroleProperty());
        cmremark.setCellValueFactory(cellData-> cellData.getValue().cmremarkProperty());
        cmpermission.setCellValueFactory(cellData-> cellData.getValue().cmpermissionProperty());
        cmoperate.setCellValueFactory(cellData-> cellData.getValue().cmoperateProperty());


        //节点管理
        nodeState.setCellValueFactory(cellData-> cellData.getValue().city_stateProperty());
        nodecityId.setCellValueFactory(cellData-> cellData.getValue().city_idProperty());
        nodecityname.setCellValueFactory(cellData-> cellData.getValue().city_nameProperty());
        nodeinstitutioonname.setCellValueFactory(cellData-> cellData.getValue().city_institutionProperty());
        nodedisitributionname.setCellValueFactory(cellData-> cellData.getValue().city_distributionProperty());
        nodetype.setCellValueFactory(cellData-> cellData.getValue().node_typeProperty());
        nodename.setCellValueFactory(cellData-> cellData.getValue().node_nameProperty());




        //set carrierManagement
        fmnum.setCellValueFactory(cellData-> cellData.getValue(). fmnumProperty());
        fmname.setCellValueFactory(cellData-> cellData.getValue().fmnameProperty());
        fmshortname.setCellValueFactory(cellData-> cellData.getValue().fmshortnameProperty());
        fmcontact.setCellValueFactory(cellData-> cellData.getValue().fmcontactProperty());
        fmphone.setCellValueFactory(cellData-> cellData.getValue().fmphoneProperty());
        fmtel.setCellValueFactory(cellData-> cellData.getValue().fmtelProperty());
        fmaddress.setCellValueFactory(cellData-> cellData.getValue().fmaddressProperty());
        fmremark.setCellValueFactory(cellData-> cellData.getValue().fmremarkProperty());

        //set routeManagemant
        rmstartcity.setCellValueFactory(cellData-> cellData.getValue(). rmstartcityProperty());
        rmdestinationcity.setCellValueFactory(cellData-> cellData.getValue().rmdestinationcityProperty());
        rmmode.setCellValueFactory(cellData-> cellData.getValue().rmmodeProperty());
        allone.setCellValueFactory(cellData-> cellData.getValue().rmalloneProperty());
        rmtype.setCellValueFactory(cellData-> cellData.getValue().rmtypeProperty());
        rmfirstfreight.setCellValueFactory(cellData-> cellData.getValue().rmfirstfreightProperty());
        rmlastfreight.setCellValueFactory(cellData-> cellData.getValue().rmlastfreightProperty());
        rmstarttime.setCellValueFactory(cellData-> cellData.getValue().rmstarttimeProperty());
        rmremark.setCellValueFactory(cellData-> cellData.getValue().rmoperateProperty());

        //set freightManagemant
        frcarrier.setCellValueFactory(cellData-> cellData.getValue(). frcarrierProperty());
        frstartcity.setCellValueFactory(cellData-> cellData.getValue().frstartcityProperty());
        frdestinationcity.setCellValueFactory(cellData-> cellData.getValue().frdestinationcityProperty());
        frtransport.setCellValueFactory(cellData-> cellData.getValue().frtransportProperty());
        froneall.setCellValueFactory(cellData-> cellData.getValue().froneallProperty());
        frweight.setCellValueFactory(cellData-> cellData.getValue().frweightProperty());
        frtime.setCellValueFactory(cellData-> cellData.getValue().frtimeProperty());
        frpermium.setCellValueFactory(cellData-> cellData.getValue().frpermiumProperty());
        frstarttime.setCellValueFactory(cellData-> cellData.getValue().frstarttimeProperty());
        frdeadtime.setCellValueFactory(cellData-> cellData.getValue().frdeadtimeProperty());
        froperator.setCellValueFactory(cellData-> cellData.getValue().froperatorProperty());

        //设置表格数据
        businessTableView.setItems(businessdata);
        GoodsTableView.setItems(goodsdata);
        amtableView.setItems(accountManagementdata);
        CarTypeTableView.setItems(cartypedata);
        citynodeTableView.setItems(citynodedata);
        TPGTableView.setItems(transportationPlanGenerationdata);
        carrecordTableView.setItems(carRecordsdata);
        cmTableView.setItems(cmdata);
        nodeTableView.setItems(citynodedata);
        crTableView.setItems(crdata);
        rmTableView.setItems(rmdata);
        frTableView.setItems(frdata);
        commissionedByTransportTableView.setItems(commissionedByTransportdata);
        preInformationTableView.setItems(preTransitMonitordata);
        informationTableView.setItems(transitMonitordata);
        artableview.setItems(newSignInDocdate);
        feeTableView.setItems(feedata);
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
     * 发运管理——运输委托
     */
    @FXML
    private ChoiceBox commissionedByTransportChoice;
    @FXML
    private TableColumn<CommissionedByTransport, String> commissionedByTransportNumber;
    @FXML
    private TableColumn<CommissionedByTransport, String> commissionedByTransportType;
    @FXML
    private TableColumn<CommissionedByTransport, String> commissionedByTransportCarrier;
    @FXML
    private TableColumn<CommissionedByTransport, String> commissionedByTransportWay;
    @FXML
    private TableColumn<CommissionedByTransport, String> commissionedByTransportFromPeo;
    @FXML
    private TableColumn<CommissionedByTransport, String> commissionedByTransportToPeo;
    @FXML
    private TableColumn<CommissionedByTransport, String> commissionedByTransportRemark;
    @FXML
    private TableColumn<CommissionedByTransport, String> commissionedByTransportOperator;



    @FXML
    private Button checkcommissionedByTransportBtn;
    @FXML
    void checkcommissionedByTransport(ActionEvent event) {

        String typeText = this.commissionedByTransportChoice.getValue().toString();
        if(typeText == null || typeText.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }
        else{
            commissionedByTransportTableView.getItems().clear();
        }

        //添加数据, 这些数据从数据库中查询出
        commissionedByTransportDAO commissionedByTransportationDAO = new commissionedByTransportDAO();

        Iterator<CommissionedByTransport> iter1 = commissionedByTransportationDAO.getCommissionedByTransportByCommissionedByTransportType(typeText).iterator();
        while(iter1.hasNext()) {
            commissionedByTransportdata.add(iter1.next());
        }

        //设置每列的数据


        commissionedByTransportNumber.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_numberProperty());
        commissionedByTransportType.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_typeProperty());
        commissionedByTransportCarrier.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_carrierProperty());
        commissionedByTransportWay.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_wayProperty());
        commissionedByTransportFromPeo.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_from_peoProperty());
        commissionedByTransportToPeo.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_to_peoProperty());
        commissionedByTransportRemark.setCellValueFactory(cellData-> cellData.getValue().commissionedByTransport_remarkProperty());

        //设置表格数据
        commissionedByTransportTableView.setItems(commissionedByTransportdata);

    }




    @FXML
    private Button buildcommissionedByTransportBtn;
    @FXML
    void buildcommissionedByTransport(ActionEvent event) {
        Platform.runLater(() -> {
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) buildcommissionedByTransportBtn.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new commissionedByTransportMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    @FXML
    //创建TableView
    private TableView<CommissionedByTransport> commissionedByTransportTableView = new TableView<>();
    //创建数据集合
    private ObservableList<CommissionedByTransport> commissionedByTransportdata = FXCollections.observableArrayList();


    /**
     * 在途监控——在途信息录入
     */
    @FXML
    private TableColumn<PreTransitMonitor, String> preInformationNumber;
    @FXML
    private TableColumn<PreTransitMonitor, String> preInformationState;
    @FXML
    private TableColumn<PreTransitMonitor, String> preInformationLicense;
    @FXML
    private TableColumn<PreTransitMonitor, String> preInformationOnWay;
    @FXML
    private TableColumn<PreTransitMonitor, String> preInformationCarrier;


    @FXML
    private TableView<PreTransitMonitor> preInformationTableView = new TableView<>();
    private ObservableList<PreTransitMonitor> preTransitMonitordata = FXCollections.observableArrayList();


    @FXML
    private TextField preInformationCarrier_Text;
    @FXML
    private TextField preInformationLicense_Text;
    @FXML
    private TextField preInformationNumber_Text;
    @FXML
    private TextField preInformationState_Text;
    @FXML
    private TextField preInformationOnWay_Text;

    @FXML
    private Button preInformationSaveBtn;
    @FXML
    void preInformationSave(ActionEvent event) throws SQLException {
        String PICarrier = preInformationCarrier_Text.getText();
        String PILicense = preInformationLicense_Text.getText();
        String PINumber = preInformationNumber_Text.getText();
        String PIState = preInformationState_Text.getText();
        String PIOnWay = preInformationOnWay_Text.getText();

        PreTransitMonitorDAO preTransitMonitorDAO = new PreTransitMonitorDAO();
        preTransitMonitorDAO.addPreTransitMonitor(PINumber,PILicense,PIState,PICarrier,PIOnWay);
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();

        this.preInformationCarrier_Text.clear();
        this.preInformationLicense_Text.clear();
        this.preInformationNumber_Text.clear();
        this.preInformationState_Text.clear();
        this.preInformationOnWay_Text.clear();

    }


    /**
     * 在途监控——在途监控
     */
    @FXML
    private TableColumn<TransitMonitor, String> informationNumber;
    @FXML
    private TableColumn<TransitMonitor, String> informationState;
    @FXML
    private TableColumn<TransitMonitor, String> informationLicense;
    @FXML
    private TableColumn<TransitMonitor, String> informationOnWay;
    @FXML
    private TableColumn<TransitMonitor, String> informationCarrier;
    @FXML
    private TableColumn<TransitMonitor, String> informationOperator;
    @FXML
    private TextField informationState_Text;

    @FXML
    private TableView<TransitMonitor> informationTableView = new TableView<>();
    private ObservableList<TransitMonitor> transitMonitordata = FXCollections.observableArrayList();

    @FXML
    private Button checkInformationBtn;
    @FXML
    public void checkInformation(ActionEvent event) {
        String typeText = this.informationState_Text.getText();
        if(typeText == null || typeText.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }
        else{
            informationTableView.getItems().clear();
        }

        //添加数据, 这些数据从数据库中查询出
        TransitMonitorDAO transitMonitorDAO = new TransitMonitorDAO();

        Iterator<TransitMonitor> iter1 = transitMonitorDAO.getTransitMonitorByTransitMonitorState(typeText).iterator();
        while(iter1.hasNext()) {
            transitMonitordata.add(iter1.next());
        }

        //设置每列的数据


        informationNumber.setCellValueFactory(cellData-> cellData.getValue().information_numberProperty());
        informationState.setCellValueFactory(cellData-> cellData.getValue().information_stateProperty());
        informationLicense.setCellValueFactory(cellData-> cellData.getValue().information_licenseProperty());
        informationOnWay.setCellValueFactory(cellData-> cellData.getValue().information_on_wayProperty());
        informationCarrier.setCellValueFactory(cellData-> cellData.getValue().information_carrierProperty());


        informationTableView.setItems(transitMonitordata);
    }
    @FXML
    private Button flashBtn;
    @FXML
    public void flash(ActionEvent event) {
        Platform.runLater(() -> {
            Stage primaryStage = (Stage) flashBtn.getScene().getWindow();
            primaryStage.hide();
            try {
                new MainMenu().start(primaryStage);
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
    @FXML
    private Button acfind;
    @FXML
    private TextField acnameText;
    @FXML
    void acfindchecked(ActionEvent event) {
        String acname1 = this.acnameText.getText();
        // System.out.println(cityname1);
        if(acname1 == null || acname1.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }
        else{
           amtableView.getItems().clear();
        }
        accountManagementDAO accountManagementdao = new accountManagementDAO();
        Iterator<accountManagement> iteram= accountManagementdao.getAccountByManagement(acname1).iterator();
        while(iteram.hasNext()) {
            accountManagementdata.add(iteram.next());
        }
        amaccount.setCellValueFactory(cellData-> cellData.getValue().am_accountProperty());
        amname.setCellValueFactory( cellData-> cellData.getValue().am_nameProperty());
        aminstitution.setCellValueFactory( cellData-> cellData.getValue().am_institutionProperty());
        amcity.setCellValueFactory( cellData-> cellData.getValue().am_cityProperty());
        amnode.setCellValueFactory( cellData-> cellData.getValue().am_nodeProperty());
        amtel.setCellValueFactory( cellData-> cellData.getValue().am_contactProperty());
        ammail.setCellValueFactory( cellData-> cellData.getValue().am_mailProperty());
        amtableView.setItems(accountManagementdata);

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

    /**
     * 车辆备案
     */
    @FXML
    private TextField carrecordCarnumberText;
    @FXML
    private TextField carrecordCarnumber2Text;

    @FXML
    private Button carrecordCheckBtn;
    @FXML
    private Button carrecordBuildBtn;
    @FXML
    private TableView<CarRecord> carrecordTableView = new TableView<>();
    //创建数据集合
    private ObservableList<CarRecord> carRecordsdata = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> carrecordPeopleCB ;

    @FXML
    private TableColumn<CarRecord, String> carrecordState;
    @FXML
    private TableColumn<CarRecord, String> carrecordRemark;
    @FXML
    private TableColumn<CarRecord, String> carrecordCartype;
    @FXML
    private TableColumn<CarRecord, String> carrecordOperator;
    @FXML
    private TableColumn<CarRecord, String> carrecordCarrier;
    @FXML
    private TableColumn<CarRecord, String> carrecordPeople;
    @FXML
    private TableColumn<CarRecord, String> carrecordLoad;
    @FXML
    private TableColumn<CarRecord, String> carrecordNumber1;
    @FXML
    private TableColumn<CarRecord, String> carrecordNumber2;
    @FXML
    private TableColumn<CarRecord, String> carrecordTel;
    @FXML
    private TableColumn<CarRecord, String> carrecordVolume;


    @FXML
    void carrecordCheck(ActionEvent event) {

        String carRecordCarrier = this.carrecordPeopleCB.getValue().toString();

        if(carRecordCarrier == null || carRecordCarrier.length() <= 0){
            //new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
            System.out.println("查询内容为空");
        }
        else{
            carrecordTableView.getItems().clear();
            //添加数据, 这些数据从数据库中查询出
            carRecordDAO carRecordDAO2 = new carRecordDAO();

            Iterator<CarRecord> carRecordIterator = carRecordDAO2.getCarRecordByCarrier(carRecordCarrier).iterator();
            while(carRecordIterator.hasNext()) {
                carRecordsdata.add(carRecordIterator.next());

            }

        }


        String carnumber = this.carrecordCarnumberText.getText();
        // System.out.println(cityname1);
        if(carnumber == null || carnumber.length() <= 0){
            System.out.println("查询内容为空");
        }
        else{
            carrecordTableView.getItems().clear();
            //添加数据, 这些数据从数据库中查询出
            carRecordDAO carRecordDAO3 = new carRecordDAO();

            Iterator<CarRecord> carRecordIterator1 = carRecordDAO3.getCarRecordByCarnumber(carnumber).iterator();
            while(carRecordIterator1.hasNext()) {
                carRecordsdata.add(carRecordIterator1.next());

            }
        }



        //设置车辆备案数据
        carrecordState.setCellValueFactory(cellData-> cellData.getValue().car_stateProperty());
        carrecordRemark.setCellValueFactory(cellData-> cellData.getValue().car_remarkProperty());
        carrecordCartype.setCellValueFactory(cellData-> cellData.getValue().car_typeProperty());
        carrecordCarrier.setCellValueFactory(cellData-> cellData.getValue().car_carrierProperty());
        carrecordPeople.setCellValueFactory(cellData-> cellData.getValue().car_peopleProperty());
        carrecordLoad.setCellValueFactory(cellData-> cellData.getValue().car_loadProperty());
        carrecordNumber1.setCellValueFactory(cellData-> cellData.getValue().car_numberProperty());
        carrecordNumber2.setCellValueFactory(cellData-> cellData.getValue().trailer_numberProperty());
        carrecordTel.setCellValueFactory(cellData-> cellData.getValue().car_telephoneProperty());
        carrecordVolume.setCellValueFactory(cellData-> cellData.getValue().car_volumeProperty());

        //设置表格数据
        carrecordTableView.setItems(carRecordsdata);
    }

    @FXML
    void carrecordBuild(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) carrecordBuildBtn.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new carRecordMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }









    /**
     * characterManagement
     */
    @FXML
    private TableColumn<characterManagement,String> cmstate;
    @FXML
    private TableColumn<characterManagement,String> cmrole;
    @FXML
    private TableColumn<characterManagement,String> cmremark;
    @FXML
    private TableColumn<characterManagement,String> cmpermission;
    @FXML
    private TableColumn<characterManagement,String> cmoperate;
    @FXML
    private Button cmnew;
    @FXML
    //创建TableView
    private TableView<characterManagement> cmTableView = new TableView<>();
    //创建数据集合
    private ObservableList<characterManagement> cmdata = FXCollections.observableArrayList();
    @FXML
    void cmnewchecked(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) cmnew.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new characterManagementMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
    @FXML
    private Button cmfind;
    @FXML
    private TextField cmtext;
    @FXML
    void checkedcmfind(ActionEvent event) {
        if(cmtext.getText().length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }
        else{
            cmTableView.getItems().clear();
        }


        //添加数据, 这些数据从数据库中查询出
        characterManagementDAO characterManagementdao = new characterManagementDAO();
        Iterator<characterManagement> cmiter = characterManagementdao.getCharacterByManagement(cmtext.getText()).iterator();
        while(cmiter.hasNext()) {
            cmdata.add(cmiter.next());
        }

        cmrole.setCellValueFactory(cellData-> cellData.getValue(). cmroleProperty());
        cmremark.setCellValueFactory(cellData-> cellData.getValue().cmremarkProperty());
        cmpermission.setCellValueFactory(cellData-> cellData.getValue().cmpermissionProperty());
        cmoperate.setCellValueFactory(cellData-> cellData.getValue().cmoperateProperty());
        cmTableView.setItems(cmdata);


    }
    /**
    * 节点管理
    */

    @FXML
    private TextField nodenameText;
    @FXML
    private ComboBox CityCB;
    @FXML
    private Button nodeCheckBtn;
    @FXML
    private Button nodebuildBtn;

    @FXML
    private TableView<CityNode> nodeTableView = new TableView<>();

    //创建数据集合
    private ObservableList<CityNode> nodedata = FXCollections.observableArrayList();

    @FXML
    private TableColumn<CityNode, String> nodecityname;
    @FXML
    private TableColumn<CityNode, String> nodename;
    @FXML
    private TableColumn<CityNode, String> nodeinstitutioonname;
    @FXML
    private TableColumn<CityNode, String> nodecityId;
    @FXML
    private TableColumn<CityNode, String> nodeState;
    @FXML
    private TableColumn<CityNode, String> nodetype;
    @FXML
    private TableColumn<CityNode, String> nodedisitributionname;
    @FXML
    private TableColumn<CityNode, String> nodeOperator;



    @FXML
    void nodeCheck(ActionEvent event) {

        String cityname2 = this.CityCB.getValue().toString();
        // System.out.println(cityname1);
        if(cityname2 == null || cityname2.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }

        else{
            nodeTableView.getItems().clear();
        }

        //添加数据, 这些数据从数据库中查询出
        city_nodeDAO city_nodeDAO1 = new city_nodeDAO();

        Iterator<CityNode> cityNodeIterator1 = city_nodeDAO1.getCitynodeBycityName(cityname2).iterator();
        while(cityNodeIterator1.hasNext()) {
            citynodedata.add(cityNodeIterator1.next());

        }
        //节点管理
        nodeState.setCellValueFactory(cellData-> cellData.getValue().city_stateProperty());
        nodecityId.setCellValueFactory(cellData-> cellData.getValue().city_idProperty());
        nodecityname.setCellValueFactory(cellData-> cellData.getValue().city_nameProperty());
        nodeinstitutioonname.setCellValueFactory(cellData-> cellData.getValue().city_institutionProperty());
        nodedisitributionname.setCellValueFactory(cellData-> cellData.getValue().city_distributionProperty());
        nodetype.setCellValueFactory(cellData-> cellData.getValue().node_typeProperty());
        nodename.setCellValueFactory(cellData-> cellData.getValue().node_nameProperty());

        //设置表格数据
        nodeTableView.setItems(citynodedata);

    }

    @FXML
    void nodebuild(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) nodebuildBtn.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new nodeMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

/**
 * carrierManagement
 */
    @FXML
    private TableColumn<carrierManagement,String> fmstate;
    @FXML
    private TableColumn<carrierManagement,String> fmnum;
    @FXML
    private TableColumn<carrierManagement,String> fmname;
    @FXML
    private TableColumn<carrierManagement,String> fmshortname;
    @FXML
    private TableColumn<carrierManagement,String> fmcontact;
    @FXML
    private TableColumn<carrierManagement,String> fmphone;
    @FXML
    private TableColumn<carrierManagement,String> fmtel;
    @FXML
    private TableColumn<carrierManagement,String> fmaddress;
    @FXML
    private TableColumn<carrierManagement,String> fmremark;
    @FXML
    private TableColumn<carrierManagement,String> fmoperate;
    @FXML
    //创建TableView
    private TableView<carrierManagement> crTableView = new TableView<>();
    //创建数据集合
    private ObservableList<carrierManagement> crdata = FXCollections.observableArrayList();
    @FXML
    private Button fmfind;
    @FXML
    private Button newCarrier;
    @FXML
    void fmnew(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) newCarrier.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new carrierManagementMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
    @FXML
    private TextField fmname1;
    @FXML
    void fmfindchecked(ActionEvent event) {

        String fmname2 = this.fmname1.getText();
        // System.out.println(cityname1);
        if(fmname2 == null || fmname2.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }
        else{
            crTableView.getItems().clear();
        }
        carrierManagementDAO carrierManagementdao = new carrierManagementDAO();
        Iterator<carrierManagement> criter = carrierManagementdao.getCarrierByManagement(fmname2).iterator();
        while(criter.hasNext()) {
            crdata.add(criter.next());
        }


        fmnum.setCellValueFactory(cellData-> cellData.getValue(). fmnumProperty());
        fmname.setCellValueFactory(cellData-> cellData.getValue().fmnameProperty());
        fmshortname.setCellValueFactory(cellData-> cellData.getValue().fmshortnameProperty());
        fmcontact.setCellValueFactory(cellData-> cellData.getValue().fmcontactProperty());
        fmphone.setCellValueFactory(cellData-> cellData.getValue().fmphoneProperty());
        fmtel.setCellValueFactory(cellData-> cellData.getValue().fmtelProperty());
        fmaddress.setCellValueFactory(cellData-> cellData.getValue().fmaddressProperty());
        fmremark.setCellValueFactory(cellData-> cellData.getValue().fmremarkProperty());
        crTableView.setItems(crdata);



    }






    /**
     * freightManagement
     */
    @FXML
    private TableColumn<freightManagement,String> frid;
    @FXML
    private TableColumn<freightManagement,String> frcarrier;
    @FXML
    private TableColumn<freightManagement,String> frstartcity;
    @FXML
    private TableColumn<freightManagement,String> frdestinationcity;
    @FXML
    private TableColumn<freightManagement,String> frtransport;
    @FXML
    private TableColumn<freightManagement,String> froneall;
    @FXML
    private TableColumn<freightManagement,String> frweight;
    @FXML
    private TableColumn<freightManagement,String> frtime;
    @FXML
    private TableColumn<freightManagement,String> frpermium;
    @FXML
    private TableColumn<freightManagement,String> frstarttime;
    @FXML
    private TableColumn<freightManagement,String> frdeadtime;
    @FXML
    private TableColumn<freightManagement,String> froperator;
    @FXML
    //创建TableView
    private TableView<freightManagement> frTableView = new TableView<>();
    //创建数据集合
    private ObservableList<freightManagement> frdata = FXCollections.observableArrayList();
    @FXML
    private Button frnewchecked;
    @FXML
    private Button frfindchecked;
    @FXML
    void frnew(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) frnewchecked.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new freightManagementMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }
    @FXML
    private Button frfind;
    @FXML
    private TextField frname;
    @FXML
    void frfindcheck(ActionEvent event) {

        String frname1 = this.frname.getText();
        // System.out.println(cityname1);
        if(frname1 == null || frname1.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }
        else{
            frTableView.getItems().clear();
        }

        freightManagementDAO freightmanagementdao = new freightManagementDAO();
        Iterator<freightManagement> friter = freightmanagementdao.getFreightByManagement(frname1).iterator();

        while(friter.hasNext()) {
            frdata.add(friter.next());
        }
        frTableView.setItems(frdata);
        //set freightManagemant
        frcarrier.setCellValueFactory(cellData-> cellData.getValue(). frcarrierProperty());
        frstartcity.setCellValueFactory(cellData-> cellData.getValue().frstartcityProperty());
        frdestinationcity.setCellValueFactory(cellData-> cellData.getValue().frdestinationcityProperty());
        frtransport.setCellValueFactory(cellData-> cellData.getValue().frtransportProperty());
        froneall.setCellValueFactory(cellData-> cellData.getValue().froneallProperty());
        frweight.setCellValueFactory(cellData-> cellData.getValue().frweightProperty());
        frtime.setCellValueFactory(cellData-> cellData.getValue().frtimeProperty());
        frpermium.setCellValueFactory(cellData-> cellData.getValue().frpermiumProperty());
        frstarttime.setCellValueFactory(cellData-> cellData.getValue().frstarttimeProperty());
        frdeadtime.setCellValueFactory(cellData-> cellData.getValue().frdeadtimeProperty());
        froperator.setCellValueFactory(cellData-> cellData.getValue().froperatorProperty());


    }

    /**
     * routeManagement
     */

    @FXML
    private TableColumn<routeManagement,String> rmstate;
    @FXML
    private TableColumn<routeManagement,String> rmstartcity;
    @FXML
    private TableColumn<routeManagement,String> rmdestinationcity;
    @FXML
    private TableColumn<routeManagement,String> rmmode;
    @FXML
    private TableColumn<routeManagement,String> allone;
    @FXML
    private TableColumn<routeManagement,String> rmtype;
    @FXML
    private TableColumn<routeManagement,String> rmfirstfreight;
    @FXML
    private TableColumn<routeManagement,String> rmlastfreight;
    @FXML
    private TableColumn<routeManagement,String> rmstarttime;
    @FXML
    private TableColumn<routeManagement,String> rmremark;
    @FXML
    private TableColumn<routeManagement,String> rmoperate;
    @FXML
    //创建TableView
    private TableView<routeManagement> rmTableView = new TableView<>();
    //创建数据集合
    private ObservableList<routeManagement> rmdata = FXCollections.observableArrayList();
    @FXML
    private Button rmfind;
    @FXML
    private Button newroute;
    @FXML
    void rmnew(ActionEvent event) {
        Platform.runLater(() -> {
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) newroute.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new routeManagementMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
    @FXML
    private TextField rmname;
    @FXML
    void rmfindchecked(ActionEvent event) {

        String rmname1 = this.rmname.getText();
        // System.out.println(cityname1);
        if(rmname1 == null || rmname1.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }
        else{
            rmTableView.getItems().clear();
        }

        routeManagmentDAO routemanagementdao = new routeManagmentDAO();
        Iterator<routeManagement> rmiter = routemanagementdao.getRouteByManagement(rmname1).iterator();
        while(rmiter.hasNext()) {
            rmdata.add(rmiter.next());
        }

        //set routeManagemant
        rmstartcity.setCellValueFactory(cellData-> cellData.getValue(). rmstartcityProperty());
        rmdestinationcity.setCellValueFactory(cellData-> cellData.getValue().rmdestinationcityProperty());
        rmmode.setCellValueFactory(cellData-> cellData.getValue().rmmodeProperty());
        allone.setCellValueFactory(cellData-> cellData.getValue().rmalloneProperty());
        rmtype.setCellValueFactory(cellData-> cellData.getValue().rmtypeProperty());
        rmfirstfreight.setCellValueFactory(cellData-> cellData.getValue().rmfirstfreightProperty());
        rmlastfreight.setCellValueFactory(cellData-> cellData.getValue().rmlastfreightProperty());
        rmstarttime.setCellValueFactory(cellData-> cellData.getValue().rmstarttimeProperty());
        rmremark.setCellValueFactory(cellData-> cellData.getValue().rmoperateProperty());
        rmTableView.setItems(rmdata);


    }

    /**
     * 到货管理
     */
    @FXML
    private TableView<newSignInDoc> artableview = new TableView<>();
    //创建数据集合
    private ObservableList<newSignInDoc> newSignInDocdate = FXCollections.observableArrayList();
    @FXML
    private TextField goodgetbinubo;
    @FXML
    private TableColumn<newSignInDoc, String> goodgetnub;
    @FXML
    private TableColumn<newSignInDoc, String> goodgetfcity;
    @FXML
    private TableColumn<newSignInDoc, String> goodgetfhouse;
    @FXML
    private TableColumn<newSignInDoc, String> goodgetlcity;
    @FXML
    private TableColumn<newSignInDoc, String> goodgetlhouse;
    @FXML
    private TableColumn<newSignInDoc, String> goodgetgoodarea;
    @FXML
    private TableColumn<newSignInDoc, String> goodgetgetarea;
    @FXML
    private TableColumn<newSignInDoc, String> goodgetpeople;
    @FXML
    private TableColumn<newSignInDoc, String> goodgetrunway;
    @FXML
    private TableColumn<newSignInDoc, String> goodgettype;
    @FXML
    private TableColumn<newSignInDoc, String> goodgetgoodmuch;
    @FXML
    private TableColumn<newSignInDoc, String> goodgetwrite;
    @FXML
    private TableColumn<newSignInDoc, String> goodgetaction;
    @FXML
    private Button goodcheckBtn;
    @FXML
    private Button goodbuildBtn;




    @FXML
    void goodbuild(ActionEvent event) {
        //businessmain business = new businessmain();
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) goodbuildBtn.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new newSignInDocMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    @FXML
    void gooddCheck(ActionEvent event) {//getCellValueFactory().toString();
        String goodName1 = this.goodgetgoodmuch.getText();
        if(goodName1 == null || goodName1.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }
        else{
            artableview.getItems().clear();
        }

        //添加数据, 这些数据从数据库中查询出
        newSignInDocDAO NewSignInDocDAO = new newSignInDocDAO();

        Iterator<newSignInDoc> newSignInDoctier = NewSignInDocDAO.getNewSignInDocByGoodGetType(goodName1).iterator();
        while(newSignInDoctier.hasNext()) {
            newSignInDocdate.add(newSignInDoctier.next());
        }
        //设置每列的数据
        goodgetnub.setCellValueFactory(cellData-> cellData.getValue().goodget_nubProperty());
        goodgetfcity.setCellValueFactory(cellData-> cellData.getValue().goodget_fcityProperty());
        goodgetfhouse.setCellValueFactory(cellData-> cellData.getValue().goodget_fhouseProperty());
        goodgetlcity.setCellValueFactory(cellData-> cellData.getValue().goodget_lcityProperty());
        goodgetlhouse.setCellValueFactory(cellData-> cellData.getValue().goodget_lhouseProperty());
        goodgetgoodarea.setCellValueFactory(cellData-> cellData.getValue().goodget_goodareaProperty());
        goodgetgetarea.setCellValueFactory(cellData-> cellData.getValue().goodget_getareaProperty());
        goodgetpeople.setCellValueFactory(cellData-> cellData.getValue().goodget_peopleProperty());
        goodgetrunway.setCellValueFactory(cellData-> cellData.getValue().goodget_runwayProperty());
        goodgettype.setCellValueFactory(cellData-> cellData.getValue().goodget_typeProperty());
        goodgetgoodmuch.setCellValueFactory(cellData-> cellData.getValue().goodget_goodmuchProperty());
        goodgetwrite.setCellValueFactory(cellData-> cellData.getValue().goodget_writeProperty());
        goodgetaction.setCellValueFactory(cellData-> cellData.getValue().goodget_actionProperty());

        //设置表格数据
        artableview.setItems(newSignInDocdate);
    }

    /**
     * 账单调整
     */
    @FXML
    private Button feecheckBtn;
    @FXML
    private TextField feeText;
    @FXML
    private TableColumn<Fee, String> feeBooknode;
    @FXML
    private TableColumn<Fee, String> feeTransnode;
    @FXML
    private TableColumn<Fee, String> feeSubprimemoney;
    @FXML
    private TableColumn<Fee, String> feeLatemoney;
    @FXML
    private TableColumn<Fee, String> feeOthermoney;
    @FXML
    private TableColumn<Fee, String> feeWhyothermoney;
    //查询按钮
    @FXML
    void feecheck(ActionEvent event) {
        String typeText = this.feeText.getText();
        if(typeText == null || typeText.length() <= 0){
            new Alert(Alert.AlertType.NONE, "查询内容不能为空", new ButtonType[]{ButtonType.CLOSE}).show();
        }
        else{
            feeTableView.getItems().clear();
        }

        //添加数据, 这些数据从数据库中查询出
        FeeDAO feeDAO = new FeeDAO();

        Iterator<Fee> iter = feeDAO.getFeeByFeeBooknode(typeText).iterator();
        while(iter.hasNext()) {
            feedata.add(iter.next());
        }

        //设置每列的数据
        feeBooknode.setCellValueFactory(cellData-> cellData.getValue().fee_booknodeProperty());
        feeTransnode.setCellValueFactory(cellData-> cellData.getValue().fee_transnodeProperty());
        feeSubprimemoney.setCellValueFactory(cellData-> cellData.getValue().fee_subprimemoneyProperty());
        feeLatemoney.setCellValueFactory(cellData-> cellData.getValue().fee_latemoneyProperty());
        feeOthermoney.setCellValueFactory(cellData-> cellData.getValue().fee_othermoneyProperty());
        feeWhyothermoney.setCellValueFactory(cellData-> cellData.getValue().fee_whyothermoneyProperty());

        //设置表格数据
        feeTableView.setItems(feedata);

    }
    @FXML
    //创建TableView
    private TableView<Fee> feeTableView = new TableView<>();
    //创建数据集合
    private ObservableList<Fee> feedata = FXCollections.observableArrayList();
    @FXML
    private Button buildFeeBtn;
    //新建业务类型的按钮
    @FXML
    void buildFee(ActionEvent event) {
        //businessmain business = new businessmain();
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) buildFeeBtn.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new commissionedByFeeMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

}



