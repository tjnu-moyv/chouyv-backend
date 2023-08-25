package cn.chouyv.exception;

import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/16/11:38
 * @Description:
 */
public class DeleteAddressWithWrongTokenException extends ChouYvException {
    public DeleteAddressWithWrongTokenException(String message, int code, String description) {
        super(message, code, description);
    }

    public static DeleteAddressWithWrongTokenException error(String description){
        return new DeleteAddressWithWrongTokenException(ChouYvError.DELETE_WITH_WRONG_TOKEN.getMessage(), ChouYvError.DELETE_WITH_WRONG_TOKEN.getCode(), description);

    }
}
