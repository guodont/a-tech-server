package ordercenter.services;

import common.models.utils.ViewEnum;

/**
 * 分类类型明细
 * Created by llz on 2016/4/12.
 */
public enum CategoryType implements ViewEnum {

    ARTICLE("普通用户"),
    EXPERT("专家"),
    QUESTION("问题");

    public String value;

    CategoryType(String value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return toString();
    }

    @Override
    public String getValue() {
        return value;
    }
}
