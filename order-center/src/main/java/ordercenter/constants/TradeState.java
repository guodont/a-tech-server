package ordercenter.constants;

import common.models.utils.ViewEnum;

/**
 * Created by lzadmin on 2016/4/12 0012.
 * trade表中state属性的枚举类
 */
public enum  TradeState implements ViewEnum{
//    状态（WAIT_AUDITED:待审核AUDITED:已通过FAILED:
//    未
//    通过）

    WAIT_AUDITED("待审核"),
    FAILED("未通过"),
    AUDITED("已通过");
    private  String value;

    TradeState(String value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getValue() {
        return value;
    }
}
