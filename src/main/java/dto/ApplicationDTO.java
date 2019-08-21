package dto;

import lombok.Data;

/**
 * @author LYD
 * @date 2019/8/21 11:51
 */
@Data
public class ApplicationDTO {

    private int applicationid;
    private int userid;
    private int status;
    private String applyremarks;
    private String remarks;

}
