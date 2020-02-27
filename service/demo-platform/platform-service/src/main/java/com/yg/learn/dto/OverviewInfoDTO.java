package com.yg.learn.dto;

import com.cn.yjrc.domain.dto.ProcessingInfo;
import com.droideye.dto.CertificateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OverviewInfoDTO {

    /**
     * isComplete : 1
     * isRelation : 1
     * notice : {"policyNotice":[{"key":1,"notice":"北京市引进人才管理办法（试行）","noticeDate":"【2019-10-16】"},{"key":2,"notice":"2016年北京人才发展重要政策文件目录","noticeDate":"【2016-07-21】"}],"systemNotcie":[],"businessNotice":[{"key":1,"notice":"您的工作居住证即将过期，请立即办理证件续签业务"}]}
     * auth : {"unitRelation":[{"key":1,"unitName":"首都信息发展股份有限公司"}],"rcpxAuth":[{"key":1,"businessName":"人才评选","route":"","state":2,"msg":"当前单位没有开通该业务的办理权限"}],"rcyjAuth":[{"key":1,"businessName":"工作居住证","route":"","state":1,"msg":""},{"key":2,"businessName":"引进人才","route":"","state":2,"msg":"当前单位没有开通该业务的办理权限"},{"key":3,"businessName":"干部调京","route":"","state":5,"msg":"信息作假，被加入黑名单"}],"rczzAuth":[{"key":1,"businessName":"人才资质","route":"","state":3,"msg":"不满足申请资质"}],"rcfwAuth":[{"key":1,"businessName":"人才服务","route":"","state":3,"msg":"不满足申请资质"}]}
     * personalInfo : [{"key":1,"name":"测试用户","phone":"13800138000","cardType":"居民身份证","cardNum":"110108198800000000"}]
     * validCertificateCard : [{"key":1,"gzjzzType":"北京市工作居住证","gzjzzNum":"201701010001","issuanceDate":"2017年01月01日","validityDate":"2020年01月01日"}]
     * processingBusiness : [{"key":1,"opid":1000000,"isChange":1,"systemName":"工作居住证","businessName":"北京市工作居住证","businessType":"证件业务信息变更","date":"2019-01-06","processing":"退回个人修改"},{"key":1,"opid":1000001,"isChange":0,"systemName":"引进人才","businessName":"外埠人才引进","businessType":"引进人才申请","date":"2019-03-11","processing":"市局审批通过，待完善落户信息"}]
     */
    private String sfzh;
    private int isComplete;
    private int isRelation;
    private NoticeBean notice;
    private AuthBean auth;
    private List<PersonalInfoBean> personalInfo;
    private List<CertificateDTO> validCertificateCard;
    private List<ProcessingInfo> processingBusiness;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class NoticeBean {
        private List<PolicyNoticeBean> policyNotice;
        private List<?> systemNotcie;
        private List<BusinessNoticeBean> businessNotice;


        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class PolicyNoticeBean {
            /**
             * key : 1
             * notice : 北京市引进人才管理办法（试行）
             * noticeDate : 【2019-10-16】
             */

            private int key;
            private String notice;
            private String noticeDate;


        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class BusinessNoticeBean {
            /**
             * key : 1
             * notice : 您的工作居住证即将过期，请立即办理证件续签业务
             */

            private int key;
            private String notice;


        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class AuthBean {
        private List<UnitRelationBean> unitRelation;
        private List<RcpxAuthBean> rcpxAuth;
        private List<RcyjAuthBean> rcyjAuth;
        private List<RczzAuthBean> rczzAuth;
        private List<RcfwAuthBean> rcfwAuth;


        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class UnitRelationBean {
            /**
             * key : 1
             * unitName : 首都信息发展股份有限公司
             */

            private int key;
            private String unitName;


        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class RcpxAuthBean {
            /**
             * key : 1
             * businessName : 人才评选
             * route :
             * state : 2
             * msg : 当前单位没有开通该业务的办理权限
             */

            private int key;
            private String businessName;
            private String route;
            private int state;
            private String msg;


        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class RcyjAuthBean {
            /**
             * key : 1
             * businessName : 工作居住证
             * route :
             * state : 1
             * msg :
             */

            private int key;
            private String businessName;
            private String route;
            private int state;
            private String msg;


        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class RczzAuthBean {
            /**
             * key : 1
             * businessName : 人才资质
             * route :
             * state : 3
             * msg : 不满足申请资质
             */

            private int key;
            private String businessName;
            private String route;
            private int state;
            private String msg;


        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class RcfwAuthBean {
            /**
             * key : 1
             * businessName : 人才服务
             * route :
             * state : 3
             * msg : 不满足申请资质
             */

            private int key;
            private String businessName;
            private String route;
            private int state;
            private String msg;


        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class PersonalInfoBean {
        /**
         * key : 1
         * name : 测试用户
         * phone : 13800138000
         * cardType : 居民身份证
         * cardNum : 110108198800000000
         */

        private int key;
        private String name;
        private String phone;
        private String cardType;
        private String cardNum;


    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ValidCertificateCardBean {
        /**
         * key : 1
         * gzjzzType : 北京市工作居住证
         * gzjzzNum : 201701010001
         * issuanceDate : 2017年01月01日
         * validityDate : 2020年01月01日
         */

        private int key;
        private String gzjzzType;
        private String gzjzzNum;
        private String issuanceDate;
        private String validityDate;


    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ProcessingBusinessBean {
        /**
         * key : 1
         * opid : 1000000
         * isChange : 1
         * systemName : 工作居住证
         * businessName : 北京市工作居住证
         * businessType : 证件业务信息变更
         * date : 2019-01-06
         * processing : 退回个人修改
         */

        private int key;
        private int opid;
        private int isChange;
        private String systemName;
        private String businessName;
        private String businessType;
        private String date;
        private String processing;


    }
}
