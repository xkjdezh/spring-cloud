package com.bichuang.openapi.repository.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenPhoneRechargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpenPhoneRechargeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("`ID` is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("`ID` is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("`ID` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("`ID` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("`ID` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`ID` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("`ID` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("`ID` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("`ID` in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("`ID` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("`ID` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`ID` not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("`USER_ID` is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("`USER_ID` is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("`USER_ID` =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("`USER_ID` <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("`USER_ID` >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("`USER_ID` >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("`USER_ID` <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("`USER_ID` <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("`USER_ID` in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("`USER_ID` not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("`USER_ID` between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("`USER_ID` not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNull() {
            addCriterion("`USER_ROLE` is null");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNotNull() {
            addCriterion("`USER_ROLE` is not null");
            return (Criteria) this;
        }

        public Criteria andUserRoleEqualTo(String value) {
            addCriterion("`USER_ROLE` =", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotEqualTo(String value) {
            addCriterion("`USER_ROLE` <>", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThan(String value) {
            addCriterion("`USER_ROLE` >", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThanOrEqualTo(String value) {
            addCriterion("`USER_ROLE` >=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThan(String value) {
            addCriterion("`USER_ROLE` <", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThanOrEqualTo(String value) {
            addCriterion("`USER_ROLE` <=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLike(String value) {
            addCriterion("`USER_ROLE` like", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotLike(String value) {
            addCriterion("`USER_ROLE` not like", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleIn(List<String> values) {
            addCriterion("`USER_ROLE` in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotIn(List<String> values) {
            addCriterion("`USER_ROLE` not in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleBetween(String value1, String value2) {
            addCriterion("`USER_ROLE` between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotBetween(String value1, String value2) {
            addCriterion("`USER_ROLE` not between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNull() {
            addCriterion("`MOBILE_PHONE` is null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNotNull() {
            addCriterion("`MOBILE_PHONE` is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneEqualTo(String value) {
            addCriterion("`MOBILE_PHONE` =", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotEqualTo(String value) {
            addCriterion("`MOBILE_PHONE` <>", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThan(String value) {
            addCriterion("`MOBILE_PHONE` >", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("`MOBILE_PHONE` >=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThan(String value) {
            addCriterion("`MOBILE_PHONE` <", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("`MOBILE_PHONE` <=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLike(String value) {
            addCriterion("`MOBILE_PHONE` like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotLike(String value) {
            addCriterion("`MOBILE_PHONE` not like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIn(List<String> values) {
            addCriterion("`MOBILE_PHONE` in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotIn(List<String> values) {
            addCriterion("`MOBILE_PHONE` not in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneBetween(String value1, String value2) {
            addCriterion("`MOBILE_PHONE` between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("`MOBILE_PHONE` not between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNull() {
            addCriterion("`BIZ_TYPE` is null");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNotNull() {
            addCriterion("`BIZ_TYPE` is not null");
            return (Criteria) this;
        }

        public Criteria andBizTypeEqualTo(Short value) {
            addCriterion("`BIZ_TYPE` =", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotEqualTo(Short value) {
            addCriterion("`BIZ_TYPE` <>", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThan(Short value) {
            addCriterion("`BIZ_TYPE` >", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("`BIZ_TYPE` >=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThan(Short value) {
            addCriterion("`BIZ_TYPE` <", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThanOrEqualTo(Short value) {
            addCriterion("`BIZ_TYPE` <=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeIn(List<Short> values) {
            addCriterion("`BIZ_TYPE` in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotIn(List<Short> values) {
            addCriterion("`BIZ_TYPE` not in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeBetween(Short value1, Short value2) {
            addCriterion("`BIZ_TYPE` between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotBetween(Short value1, Short value2) {
            addCriterion("`BIZ_TYPE` not between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("`ORDER_ID` is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("`ORDER_ID` is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("`ORDER_ID` =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("`ORDER_ID` <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("`ORDER_ID` >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("`ORDER_ID` >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("`ORDER_ID` <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("`ORDER_ID` <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("`ORDER_ID` like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("`ORDER_ID` not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("`ORDER_ID` in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("`ORDER_ID` not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("`ORDER_ID` between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("`ORDER_ID` not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("`TASK_ID` is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("`TASK_ID` is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("`TASK_ID` =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("`TASK_ID` <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("`TASK_ID` >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("`TASK_ID` >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("`TASK_ID` <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("`TASK_ID` <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("`TASK_ID` like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("`TASK_ID` not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("`TASK_ID` in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("`TASK_ID` not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("`TASK_ID` between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("`TASK_ID` not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andInitSubmitTimeIsNull() {
            addCriterion("`INIT_SUBMIT_TIME` is null");
            return (Criteria) this;
        }

        public Criteria andInitSubmitTimeIsNotNull() {
            addCriterion("`INIT_SUBMIT_TIME` is not null");
            return (Criteria) this;
        }

        public Criteria andInitSubmitTimeEqualTo(Date value) {
            addCriterion("`INIT_SUBMIT_TIME` =", value, "initSubmitTime");
            return (Criteria) this;
        }

        public Criteria andInitSubmitTimeNotEqualTo(Date value) {
            addCriterion("`INIT_SUBMIT_TIME` <>", value, "initSubmitTime");
            return (Criteria) this;
        }

        public Criteria andInitSubmitTimeGreaterThan(Date value) {
            addCriterion("`INIT_SUBMIT_TIME` >", value, "initSubmitTime");
            return (Criteria) this;
        }

        public Criteria andInitSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`INIT_SUBMIT_TIME` >=", value, "initSubmitTime");
            return (Criteria) this;
        }

        public Criteria andInitSubmitTimeLessThan(Date value) {
            addCriterion("`INIT_SUBMIT_TIME` <", value, "initSubmitTime");
            return (Criteria) this;
        }

        public Criteria andInitSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("`INIT_SUBMIT_TIME` <=", value, "initSubmitTime");
            return (Criteria) this;
        }

        public Criteria andInitSubmitTimeIn(List<Date> values) {
            addCriterion("`INIT_SUBMIT_TIME` in", values, "initSubmitTime");
            return (Criteria) this;
        }

        public Criteria andInitSubmitTimeNotIn(List<Date> values) {
            addCriterion("`INIT_SUBMIT_TIME` not in", values, "initSubmitTime");
            return (Criteria) this;
        }

        public Criteria andInitSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("`INIT_SUBMIT_TIME` between", value1, value2, "initSubmitTime");
            return (Criteria) this;
        }

        public Criteria andInitSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("`INIT_SUBMIT_TIME` not between", value1, value2, "initSubmitTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`STATUS` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`STATUS` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`STATUS` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`STATUS` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`STATUS` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`STATUS` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`STATUS` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`STATUS` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`STATUS` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`STATUS` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`STATUS` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`STATUS` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("`MESSAGE` is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("`MESSAGE` is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("`MESSAGE` =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("`MESSAGE` <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("`MESSAGE` >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("`MESSAGE` >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("`MESSAGE` <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("`MESSAGE` <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("`MESSAGE` like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("`MESSAGE` not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("`MESSAGE` in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("`MESSAGE` not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("`MESSAGE` between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("`MESSAGE` not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andApplyAmountIsNull() {
            addCriterion("`APPLY_AMOUNT` is null");
            return (Criteria) this;
        }

        public Criteria andApplyAmountIsNotNull() {
            addCriterion("`APPLY_AMOUNT` is not null");
            return (Criteria) this;
        }

        public Criteria andApplyAmountEqualTo(BigDecimal value) {
            addCriterion("`APPLY_AMOUNT` =", value, "applyAmount");
            return (Criteria) this;
        }

        public Criteria andApplyAmountNotEqualTo(BigDecimal value) {
            addCriterion("`APPLY_AMOUNT` <>", value, "applyAmount");
            return (Criteria) this;
        }

        public Criteria andApplyAmountGreaterThan(BigDecimal value) {
            addCriterion("`APPLY_AMOUNT` >", value, "applyAmount");
            return (Criteria) this;
        }

        public Criteria andApplyAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`APPLY_AMOUNT` >=", value, "applyAmount");
            return (Criteria) this;
        }

        public Criteria andApplyAmountLessThan(BigDecimal value) {
            addCriterion("`APPLY_AMOUNT` <", value, "applyAmount");
            return (Criteria) this;
        }

        public Criteria andApplyAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`APPLY_AMOUNT` <=", value, "applyAmount");
            return (Criteria) this;
        }

        public Criteria andApplyAmountIn(List<BigDecimal> values) {
            addCriterion("`APPLY_AMOUNT` in", values, "applyAmount");
            return (Criteria) this;
        }

        public Criteria andApplyAmountNotIn(List<BigDecimal> values) {
            addCriterion("`APPLY_AMOUNT` not in", values, "applyAmount");
            return (Criteria) this;
        }

        public Criteria andApplyAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`APPLY_AMOUNT` between", value1, value2, "applyAmount");
            return (Criteria) this;
        }

        public Criteria andApplyAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`APPLY_AMOUNT` not between", value1, value2, "applyAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountIsNull() {
            addCriterion("`ACTUAL_AMOUNT` is null");
            return (Criteria) this;
        }

        public Criteria andActualAmountIsNotNull() {
            addCriterion("`ACTUAL_AMOUNT` is not null");
            return (Criteria) this;
        }

        public Criteria andActualAmountEqualTo(BigDecimal value) {
            addCriterion("`ACTUAL_AMOUNT` =", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotEqualTo(BigDecimal value) {
            addCriterion("`ACTUAL_AMOUNT` <>", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountGreaterThan(BigDecimal value) {
            addCriterion("`ACTUAL_AMOUNT` >", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`ACTUAL_AMOUNT` >=", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountLessThan(BigDecimal value) {
            addCriterion("`ACTUAL_AMOUNT` <", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`ACTUAL_AMOUNT` <=", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountIn(List<BigDecimal> values) {
            addCriterion("`ACTUAL_AMOUNT` in", values, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotIn(List<BigDecimal> values) {
            addCriterion("`ACTUAL_AMOUNT` not in", values, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`ACTUAL_AMOUNT` between", value1, value2, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`ACTUAL_AMOUNT` not between", value1, value2, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountIsNull() {
            addCriterion("`DEDUCT_AMOUNT` is null");
            return (Criteria) this;
        }

        public Criteria andDeductAmountIsNotNull() {
            addCriterion("`DEDUCT_AMOUNT` is not null");
            return (Criteria) this;
        }

        public Criteria andDeductAmountEqualTo(BigDecimal value) {
            addCriterion("`DEDUCT_AMOUNT` =", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountNotEqualTo(BigDecimal value) {
            addCriterion("`DEDUCT_AMOUNT` <>", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountGreaterThan(BigDecimal value) {
            addCriterion("`DEDUCT_AMOUNT` >", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`DEDUCT_AMOUNT` >=", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountLessThan(BigDecimal value) {
            addCriterion("`DEDUCT_AMOUNT` <", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`DEDUCT_AMOUNT` <=", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountIn(List<BigDecimal> values) {
            addCriterion("`DEDUCT_AMOUNT` in", values, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountNotIn(List<BigDecimal> values) {
            addCriterion("`DEDUCT_AMOUNT` not in", values, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`DEDUCT_AMOUNT` between", value1, value2, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`DEDUCT_AMOUNT` not between", value1, value2, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andCertIdIsNull() {
            addCriterion("`CERT_ID` is null");
            return (Criteria) this;
        }

        public Criteria andCertIdIsNotNull() {
            addCriterion("`CERT_ID` is not null");
            return (Criteria) this;
        }

        public Criteria andCertIdEqualTo(String value) {
            addCriterion("`CERT_ID` =", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdNotEqualTo(String value) {
            addCriterion("`CERT_ID` <>", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdGreaterThan(String value) {
            addCriterion("`CERT_ID` >", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdGreaterThanOrEqualTo(String value) {
            addCriterion("`CERT_ID` >=", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdLessThan(String value) {
            addCriterion("`CERT_ID` <", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdLessThanOrEqualTo(String value) {
            addCriterion("`CERT_ID` <=", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdLike(String value) {
            addCriterion("`CERT_ID` like", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdNotLike(String value) {
            addCriterion("`CERT_ID` not like", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdIn(List<String> values) {
            addCriterion("`CERT_ID` in", values, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdNotIn(List<String> values) {
            addCriterion("`CERT_ID` not in", values, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdBetween(String value1, String value2) {
            addCriterion("`CERT_ID` between", value1, value2, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdNotBetween(String value1, String value2) {
            addCriterion("`CERT_ID` not between", value1, value2, "certId");
            return (Criteria) this;
        }

        public Criteria andProvidrSubmitTimeIsNull() {
            addCriterion("`PROVIDR_SUBMIT_TIME` is null");
            return (Criteria) this;
        }

        public Criteria andProvidrSubmitTimeIsNotNull() {
            addCriterion("`PROVIDR_SUBMIT_TIME` is not null");
            return (Criteria) this;
        }

        public Criteria andProvidrSubmitTimeEqualTo(Date value) {
            addCriterion("`PROVIDR_SUBMIT_TIME` =", value, "providrSubmitTime");
            return (Criteria) this;
        }

        public Criteria andProvidrSubmitTimeNotEqualTo(Date value) {
            addCriterion("`PROVIDR_SUBMIT_TIME` <>", value, "providrSubmitTime");
            return (Criteria) this;
        }

        public Criteria andProvidrSubmitTimeGreaterThan(Date value) {
            addCriterion("`PROVIDR_SUBMIT_TIME` >", value, "providrSubmitTime");
            return (Criteria) this;
        }

        public Criteria andProvidrSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`PROVIDR_SUBMIT_TIME` >=", value, "providrSubmitTime");
            return (Criteria) this;
        }

        public Criteria andProvidrSubmitTimeLessThan(Date value) {
            addCriterion("`PROVIDR_SUBMIT_TIME` <", value, "providrSubmitTime");
            return (Criteria) this;
        }

        public Criteria andProvidrSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("`PROVIDR_SUBMIT_TIME` <=", value, "providrSubmitTime");
            return (Criteria) this;
        }

        public Criteria andProvidrSubmitTimeIn(List<Date> values) {
            addCriterion("`PROVIDR_SUBMIT_TIME` in", values, "providrSubmitTime");
            return (Criteria) this;
        }

        public Criteria andProvidrSubmitTimeNotIn(List<Date> values) {
            addCriterion("`PROVIDR_SUBMIT_TIME` not in", values, "providrSubmitTime");
            return (Criteria) this;
        }

        public Criteria andProvidrSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("`PROVIDR_SUBMIT_TIME` between", value1, value2, "providrSubmitTime");
            return (Criteria) this;
        }

        public Criteria andProvidrSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("`PROVIDR_SUBMIT_TIME` not between", value1, value2, "providrSubmitTime");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("`CODE` is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("`CODE` is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Integer value) {
            addCriterion("`CODE` =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Integer value) {
            addCriterion("`CODE` <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Integer value) {
            addCriterion("`CODE` >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`CODE` >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Integer value) {
            addCriterion("`CODE` <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Integer value) {
            addCriterion("`CODE` <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Integer> values) {
            addCriterion("`CODE` in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Integer> values) {
            addCriterion("`CODE` not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Integer value1, Integer value2) {
            addCriterion("`CODE` between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("`CODE` not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andProvidrResultTimeIsNull() {
            addCriterion("`PROVIDR_RESULT_TIME` is null");
            return (Criteria) this;
        }

        public Criteria andProvidrResultTimeIsNotNull() {
            addCriterion("`PROVIDR_RESULT_TIME` is not null");
            return (Criteria) this;
        }

        public Criteria andProvidrResultTimeEqualTo(Date value) {
            addCriterion("`PROVIDR_RESULT_TIME` =", value, "providrResultTime");
            return (Criteria) this;
        }

        public Criteria andProvidrResultTimeNotEqualTo(Date value) {
            addCriterion("`PROVIDR_RESULT_TIME` <>", value, "providrResultTime");
            return (Criteria) this;
        }

        public Criteria andProvidrResultTimeGreaterThan(Date value) {
            addCriterion("`PROVIDR_RESULT_TIME` >", value, "providrResultTime");
            return (Criteria) this;
        }

        public Criteria andProvidrResultTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`PROVIDR_RESULT_TIME` >=", value, "providrResultTime");
            return (Criteria) this;
        }

        public Criteria andProvidrResultTimeLessThan(Date value) {
            addCriterion("`PROVIDR_RESULT_TIME` <", value, "providrResultTime");
            return (Criteria) this;
        }

        public Criteria andProvidrResultTimeLessThanOrEqualTo(Date value) {
            addCriterion("`PROVIDR_RESULT_TIME` <=", value, "providrResultTime");
            return (Criteria) this;
        }

        public Criteria andProvidrResultTimeIn(List<Date> values) {
            addCriterion("`PROVIDR_RESULT_TIME` in", values, "providrResultTime");
            return (Criteria) this;
        }

        public Criteria andProvidrResultTimeNotIn(List<Date> values) {
            addCriterion("`PROVIDR_RESULT_TIME` not in", values, "providrResultTime");
            return (Criteria) this;
        }

        public Criteria andProvidrResultTimeBetween(Date value1, Date value2) {
            addCriterion("`PROVIDR_RESULT_TIME` between", value1, value2, "providrResultTime");
            return (Criteria) this;
        }

        public Criteria andProvidrResultTimeNotBetween(Date value1, Date value2) {
            addCriterion("`PROVIDR_RESULT_TIME` not between", value1, value2, "providrResultTime");
            return (Criteria) this;
        }

        public Criteria andRevisionIsNull() {
            addCriterion("`REVISION` is null");
            return (Criteria) this;
        }

        public Criteria andRevisionIsNotNull() {
            addCriterion("`REVISION` is not null");
            return (Criteria) this;
        }

        public Criteria andRevisionEqualTo(Integer value) {
            addCriterion("`REVISION` =", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotEqualTo(Integer value) {
            addCriterion("`REVISION` <>", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionGreaterThan(Integer value) {
            addCriterion("`REVISION` >", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionGreaterThanOrEqualTo(Integer value) {
            addCriterion("`REVISION` >=", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionLessThan(Integer value) {
            addCriterion("`REVISION` <", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionLessThanOrEqualTo(Integer value) {
            addCriterion("`REVISION` <=", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionIn(List<Integer> values) {
            addCriterion("`REVISION` in", values, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotIn(List<Integer> values) {
            addCriterion("`REVISION` not in", values, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionBetween(Integer value1, Integer value2) {
            addCriterion("`REVISION` between", value1, value2, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotBetween(Integer value1, Integer value2) {
            addCriterion("`REVISION` not between", value1, value2, "revision");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("`CREATED_BY` is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("`CREATED_BY` is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("`CREATED_BY` =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("`CREATED_BY` <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("`CREATED_BY` >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("`CREATED_BY` >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("`CREATED_BY` <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("`CREATED_BY` <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("`CREATED_BY` like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("`CREATED_BY` not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("`CREATED_BY` in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("`CREATED_BY` not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("`CREATED_BY` between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("`CREATED_BY` not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("`CREATED_TIME` is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("`CREATED_TIME` is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("`CREATED_TIME` =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("`CREATED_TIME` <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("`CREATED_TIME` >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`CREATED_TIME` >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("`CREATED_TIME` <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("`CREATED_TIME` <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("`CREATED_TIME` in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("`CREATED_TIME` not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("`CREATED_TIME` between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("`CREATED_TIME` not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNull() {
            addCriterion("`UPDATED_BY` is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNotNull() {
            addCriterion("`UPDATED_BY` is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualTo(String value) {
            addCriterion("`UPDATED_BY` =", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualTo(String value) {
            addCriterion("`UPDATED_BY` <>", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThan(String value) {
            addCriterion("`UPDATED_BY` >", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualTo(String value) {
            addCriterion("`UPDATED_BY` >=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThan(String value) {
            addCriterion("`UPDATED_BY` <", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualTo(String value) {
            addCriterion("`UPDATED_BY` <=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLike(String value) {
            addCriterion("`UPDATED_BY` like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotLike(String value) {
            addCriterion("`UPDATED_BY` not like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIn(List<String> values) {
            addCriterion("`UPDATED_BY` in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotIn(List<String> values) {
            addCriterion("`UPDATED_BY` not in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByBetween(String value1, String value2) {
            addCriterion("`UPDATED_BY` between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotBetween(String value1, String value2) {
            addCriterion("`UPDATED_BY` not between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("`UPDATED_TIME` is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("`UPDATED_TIME` is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("`UPDATED_TIME` =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("`UPDATED_TIME` <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("`UPDATED_TIME` >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`UPDATED_TIME` >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("`UPDATED_TIME` <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("`UPDATED_TIME` <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("`UPDATED_TIME` in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("`UPDATED_TIME` not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("`UPDATED_TIME` between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("`UPDATED_TIME` not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}