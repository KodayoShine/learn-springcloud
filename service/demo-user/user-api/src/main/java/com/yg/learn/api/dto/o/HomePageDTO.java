package com.yg.learn.api.dto.o;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomePageDTO {

    private List<StateBean> state;
    private List<AuthBean> auth;
    private List<NoticeBean> notice;
    private List<PersonInfoBean> personInfo;
    private List<ValidCertificateCardBean> validCertificateCard;
    private List<ProcessingBusinessBean> processingBusiness;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StateBean {
        /**
         * isComplete : 1
         * isRelation : 1
         */
        private String isComplete;
        private String isRelation;
    }

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

            private String key;
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

            private String key;
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
         * show : block
         * gzjzzType : 北京市工作居住证
         * gzjzzNum : 201701010001
         * issuanceDate : 2017年01月01日
         * validityDate : 2020年01月01日
         */

        private String key;
        private String show;
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

        private String key;
        private String opid;
        private String isChange;
        private String systemName;
        private String businessName;
        private String businessType;
        private String date;
        private String processing;


    }
}
