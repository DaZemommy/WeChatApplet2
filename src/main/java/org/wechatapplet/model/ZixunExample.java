package org.wechatapplet.model;

import java.util.ArrayList;
import java.util.List;

public class ZixunExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZixunExample() {
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

        public Criteria andZidIsNull() {
            addCriterion("zid is null");
            return (Criteria) this;
        }

        public Criteria andZidIsNotNull() {
            addCriterion("zid is not null");
            return (Criteria) this;
        }

        public Criteria andZidEqualTo(Integer value) {
            addCriterion("zid =", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidNotEqualTo(Integer value) {
            addCriterion("zid <>", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidGreaterThan(Integer value) {
            addCriterion("zid >", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zid >=", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidLessThan(Integer value) {
            addCriterion("zid <", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidLessThanOrEqualTo(Integer value) {
            addCriterion("zid <=", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidIn(List<Integer> values) {
            addCriterion("zid in", values, "zid");
            return (Criteria) this;
        }

        public Criteria andZidNotIn(List<Integer> values) {
            addCriterion("zid not in", values, "zid");
            return (Criteria) this;
        }

        public Criteria andZidBetween(Integer value1, Integer value2) {
            addCriterion("zid between", value1, value2, "zid");
            return (Criteria) this;
        }

        public Criteria andZidNotBetween(Integer value1, Integer value2) {
            addCriterion("zid not between", value1, value2, "zid");
            return (Criteria) this;
        }

        public Criteria andZnameIsNull() {
            addCriterion("zname is null");
            return (Criteria) this;
        }

        public Criteria andZnameIsNotNull() {
            addCriterion("zname is not null");
            return (Criteria) this;
        }

        public Criteria andZnameEqualTo(String value) {
            addCriterion("zname =", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameNotEqualTo(String value) {
            addCriterion("zname <>", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameGreaterThan(String value) {
            addCriterion("zname >", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameGreaterThanOrEqualTo(String value) {
            addCriterion("zname >=", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameLessThan(String value) {
            addCriterion("zname <", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameLessThanOrEqualTo(String value) {
            addCriterion("zname <=", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameLike(String value) {
            addCriterion("zname like", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameNotLike(String value) {
            addCriterion("zname not like", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameIn(List<String> values) {
            addCriterion("zname in", values, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameNotIn(List<String> values) {
            addCriterion("zname not in", values, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameBetween(String value1, String value2) {
            addCriterion("zname between", value1, value2, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameNotBetween(String value1, String value2) {
            addCriterion("zname not between", value1, value2, "zname");
            return (Criteria) this;
        }

        public Criteria andZdescIsNull() {
            addCriterion("zdesc is null");
            return (Criteria) this;
        }

        public Criteria andZdescIsNotNull() {
            addCriterion("zdesc is not null");
            return (Criteria) this;
        }

        public Criteria andZdescEqualTo(String value) {
            addCriterion("zdesc =", value, "zdesc");
            return (Criteria) this;
        }

        public Criteria andZdescNotEqualTo(String value) {
            addCriterion("zdesc <>", value, "zdesc");
            return (Criteria) this;
        }

        public Criteria andZdescGreaterThan(String value) {
            addCriterion("zdesc >", value, "zdesc");
            return (Criteria) this;
        }

        public Criteria andZdescGreaterThanOrEqualTo(String value) {
            addCriterion("zdesc >=", value, "zdesc");
            return (Criteria) this;
        }

        public Criteria andZdescLessThan(String value) {
            addCriterion("zdesc <", value, "zdesc");
            return (Criteria) this;
        }

        public Criteria andZdescLessThanOrEqualTo(String value) {
            addCriterion("zdesc <=", value, "zdesc");
            return (Criteria) this;
        }

        public Criteria andZdescLike(String value) {
            addCriterion("zdesc like", value, "zdesc");
            return (Criteria) this;
        }

        public Criteria andZdescNotLike(String value) {
            addCriterion("zdesc not like", value, "zdesc");
            return (Criteria) this;
        }

        public Criteria andZdescIn(List<String> values) {
            addCriterion("zdesc in", values, "zdesc");
            return (Criteria) this;
        }

        public Criteria andZdescNotIn(List<String> values) {
            addCriterion("zdesc not in", values, "zdesc");
            return (Criteria) this;
        }

        public Criteria andZdescBetween(String value1, String value2) {
            addCriterion("zdesc between", value1, value2, "zdesc");
            return (Criteria) this;
        }

        public Criteria andZdescNotBetween(String value1, String value2) {
            addCriterion("zdesc not between", value1, value2, "zdesc");
            return (Criteria) this;
        }

        public Criteria andZuidIsNull() {
            addCriterion("zuid is null");
            return (Criteria) this;
        }

        public Criteria andZuidIsNotNull() {
            addCriterion("zuid is not null");
            return (Criteria) this;
        }

        public Criteria andZuidEqualTo(Integer value) {
            addCriterion("zuid =", value, "zuid");
            return (Criteria) this;
        }

        public Criteria andZuidNotEqualTo(Integer value) {
            addCriterion("zuid <>", value, "zuid");
            return (Criteria) this;
        }

        public Criteria andZuidGreaterThan(Integer value) {
            addCriterion("zuid >", value, "zuid");
            return (Criteria) this;
        }

        public Criteria andZuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zuid >=", value, "zuid");
            return (Criteria) this;
        }

        public Criteria andZuidLessThan(Integer value) {
            addCriterion("zuid <", value, "zuid");
            return (Criteria) this;
        }

        public Criteria andZuidLessThanOrEqualTo(Integer value) {
            addCriterion("zuid <=", value, "zuid");
            return (Criteria) this;
        }

        public Criteria andZuidIn(List<Integer> values) {
            addCriterion("zuid in", values, "zuid");
            return (Criteria) this;
        }

        public Criteria andZuidNotIn(List<Integer> values) {
            addCriterion("zuid not in", values, "zuid");
            return (Criteria) this;
        }

        public Criteria andZuidBetween(Integer value1, Integer value2) {
            addCriterion("zuid between", value1, value2, "zuid");
            return (Criteria) this;
        }

        public Criteria andZuidNotBetween(Integer value1, Integer value2) {
            addCriterion("zuid not between", value1, value2, "zuid");
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