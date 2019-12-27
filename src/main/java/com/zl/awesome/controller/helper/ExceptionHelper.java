package com.zl.awesome.controller.helper;

import com.zl.awesome.exception.TipException;
import com.zl.awesome.modal.bo.RestResponseBo;
import org.slf4j.Logger;

/**
 * @author janti
 */
public class ExceptionHelper {
    /**
     * 统一处理异常
     *
     * @param logger
     * @param msg
     * @param e
     * @return
     */
    public static RestResponseBo handlerException(Logger logger, String msg, Exception e) {
        if (e instanceof TipException) {
            msg = e.getMessage();
        } else {
            logger.error(msg, e);
        }
        return RestResponseBo.fail(msg);
    }
}
