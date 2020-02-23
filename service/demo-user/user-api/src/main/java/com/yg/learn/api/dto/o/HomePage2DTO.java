package com.yg.learn.api.dto.o;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomePage2DTO {


    /**
     * auth : {"unitRelation":[{"key":1,"unitName":"首都信息发展股份有限公司"}],"rcyjAuth":[{"key":1,"businessName":"工作居住证","route":"gzjzz","state":"success"},{"key":2,"businessName":"引进人才","route":"gzjzz","state":"success"},{"key":3,"businessName":"干部调京","route":"gzjzz","state":"success"}]}
     * notice : {"policyNotice":[{"key":"1","notice":"北京市引进人才管理办法（试行）","noticeDate":"【2019-10-16】"},{"key":"2","notice":"2016年北京人才发展重要政策文件目录","noticeDate":"【2016-07-21】"}],"systemNotcie":[],"businessNotice":[{"key":"1","notice":"您的工作居住证即将过期，请立即办理证件续签业务"}]}
     * personInfo : {"key":"1","name":"测试用户","phone":"13800138000","cardType":"居民身份证","cardNum":"110108198800000000"}
     * validCertificateCard : {"key":1,"gzjzzType":"北京市工作居住证","gzjzzNum":"201701010001","issuanceDate":"2017年01月01日","validityDate":"2020年01月01日"}
     * processingBusiness : [{"key":1,"opid":1000000,"isChange":1,"systemName":"工作居住证","businessName":"北京市工作居住证","businessType":"证件业务信息变更","date":"2019-01-06","processing":"退回个人修改"},{"key":1,"opid":1000001,"isChange":0,"systemName":"引进人才","businessName":"外埠人才引进","businessType":"引进人才申请","date":"2019-03-11","processing":"市局审批通过，待完善落户信息"}]
     */

    private AuthBean auth;
    private NoticeBean notice;
    private PersonInfoBean personInfo;
    private ValidCertificateCardBean validCertificateCard;
    private List<ProcessingBusinessBean> processingBusiness;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AuthBean {
        private List<UnitRelationBean> unitRelation;
        private List<RcyjAuthBean> rcyjAuth;


        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class UnitRelationBean {
            /**
             * key : 1
             * unitName : 首都信息发展股份有限公司
             */

            private int key;
            private String unitName;


        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class RcyjAuthBean {
            /**
             * key : 1
             * businessName : 工作居住证
             * route : gzjzz
             * state : success
             */

            private int key;
            private String businessName;
            private String route;
            private String state;


        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class NoticeBean {
        private List<PolicyNoticeBean> policyNotice;
        private List<?> systemNotcie;
        private List<BusinessNoticeBean> businessNotice;


        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class PolicyNoticeBean {
            /**
             * key : 1
             * notice : 北京市引进人才管理办法（试行）
             * noticeDate : 【2019-10-16】
             */

            private String key;
            private String notice;
            private String noticeDate;


        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class BusinessNoticeBean {
            /**
             * key : 1
             * notice : 您的工作居住证即将过期，请立即办理证件续签业务
             */

            private String key;
            private String notice;


        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PersonInfoBean {
        /**
         * key : 1
         * name : 测试用户
         * phone : 13800138000
         * cardType : 居民身份证
         * cardNum : 110108198800000000
         */

        private String key;
        private String name;
        private String phone;
        private String cardType;
        private String cardNum;


    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
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
    @AllArgsConstructor
    @NoArgsConstructor
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
