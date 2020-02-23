package com.yg.learn.service.impl;
import com.alibaba.csp.sentinel.SphU;
import com.yg.learn.api.dto.o.HomePage2DTO.AuthBean;
import com.yg.learn.api.dto.o.HomePage2DTO.NoticeBean;
import com.yg.learn.api.dto.o.HomePage2DTO.PersonInfoBean;
import com.yg.learn.api.dto.o.HomePage2DTO.ValidCertificateCardBean;

import com.google.common.collect.Lists;
import com.yg.learn.api.dto.UserDTO;
import com.yg.learn.api.dto.e.UserEnterDTO;
import com.yg.learn.api.dto.o.HomePage2DTO;
import com.yg.learn.api.dto.o.HomePageDTO;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.utils.BeanUtils;
import com.yg.learn.dao.UserMapper;
import com.yg.learn.domain.User;
import com.yg.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private UserMapper userMapper;
    private List<User> userList;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserOutDTO getDataSourceUser(Long id) {
        Optional<User> one = userMapper.findById(id);
        if(!one.isPresent()){
            return null;
        }
        User user = one.get();
        System.out.println(user);
        UserOutDTO userOutDTO = BeanUtils.transfrom(UserOutDTO.class, user);
        return userOutDTO;
    }

    @Override
    public UserOutDTO insertData(UserEnterDTO userEnterDTO) {
        User user = new User();
        user.setUsername(userEnterDTO.getUsername());
        user.setPassword(userEnterDTO.getPassword());
        User save = userMapper.save(user);
        UserOutDTO userOutDTO = BeanUtils.transfrom(UserOutDTO.class, save);
        return userOutDTO;
    }

    @Override
    public HomePageDTO gethomePage() {
        HomePageDTO homePageDTO = new HomePageDTO();
        homePageDTO.setState(Lists.newArrayList(new HomePageDTO.StateBean("1","1")));
        homePageDTO.setAuth(Lists.newArrayList(new HomePageDTO.AuthBean(
                            Lists.newArrayList(new HomePageDTO.AuthBean.UnitRelationBean("1","单位名称")),
                            Lists.newArrayList(new HomePageDTO.AuthBean.RcyjAuthBean("1","工作居住证","gzjzz","success"))
        )));
        homePageDTO.setNotice(Lists.newArrayList(new HomePageDTO.NoticeBean(
                Lists.newArrayList(new HomePageDTO.NoticeBean.PolicyNoticeBean("1","人才管理办法","2019-09-09")),
                Lists.newArrayList(""),
                Lists.newArrayList(new HomePageDTO.NoticeBean.BusinessNoticeBean("1","即将过期"))

        )));
        homePageDTO.setPersonInfo(Lists.newArrayList(new HomePageDTO.PersonInfoBean("1","测试用户","1333333333","居民身份证","123456789123456")));
        homePageDTO.setValidCertificateCard(Lists.newArrayList(new HomePageDTO.ValidCertificateCardBean("1","block","工作","201701010001","2017年01月01日","2017年01月01日")));
        homePageDTO.setProcessingBusiness(Lists.newArrayList(new HomePageDTO.ProcessingBusinessBean("1","1000000","1","工作居住证","bj工作居住证","证件业务信息变更","2019-01-06","退回个人修改")));
        return homePageDTO;
    }

    @Override
    public HomePage2DTO gethomePage2() {
        HomePage2DTO homePage2DTO = new HomePage2DTO();

        AuthBean auth = new AuthBean();
        auth.setUnitRelation(Lists.newArrayList(new AuthBean.UnitRelationBean(1, "单位名称")));
        auth.setRcyjAuth(Lists.newArrayList(new AuthBean.RcyjAuthBean(1, "工作居住证", "gzjzz", "success")));
        homePage2DTO.setAuth(auth);

        NoticeBean noticeBean = new NoticeBean();
        noticeBean.setPolicyNotice(Lists.newArrayList(new NoticeBean.PolicyNoticeBean("1","管理办法（试行）","【2019-10-16】")));
        noticeBean.setSystemNotcie(Lists.newArrayList(""));
        noticeBean.setBusinessNotice(Lists.newArrayList(new NoticeBean.BusinessNoticeBean("1","您的工作居住证即将过期，请立即办理证件续签业务")));
        homePage2DTO.setNotice(noticeBean);

        PersonInfoBean personInfo = new PersonInfoBean();
        personInfo.setKey("1");
        personInfo.setName("测试用户");
        personInfo.setPhone("13800138000");
        personInfo.setCardType("居民身份证");
        personInfo.setCardNum("110108198800000000");
        homePage2DTO.setPersonInfo(personInfo);


        ValidCertificateCardBean validCertificateCard = new ValidCertificateCardBean();
        validCertificateCard.setKey(1);
        validCertificateCard.setGzjzzType("北京市工作居住证");
        validCertificateCard.setGzjzzNum("201701010001");
        validCertificateCard.setIssuanceDate("2017年01月01日");
        validCertificateCard.setValidityDate("2020年01月01日");
        homePage2DTO.setValidCertificateCard(validCertificateCard);

        homePage2DTO.setProcessingBusiness(Lists.newArrayList(new HomePage2DTO.ProcessingBusinessBean(1,1000000,1,"工作居住证","bj工作居住证","证件业务信息变更","2019-01-06","退回个人修改")));

        return homePage2DTO;
    }


    public void asyncData() {

    }



    @PostConstruct
    public void initData() {
        userList = new ArrayList<>();
        userList.add(new User(1L, "macro", "123456"));
        userList.add(new User(2L, "andy", "123456"));
        userList.add(new User(3L, "mark", "123456"));
    }
}
