package cn.enilu.flash.api.controller.tool;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.api.helper.MySQLHelper;
import cn.enilu.flash.bean.vo.front.Rets;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 测试工具
 */
@RestController
@RequestMapping("/dbop")
public class DbOpController extends BaseController {
    @PostMapping("/userstatus")
    public Object setUserStatus(String userName, String status){
        MySQLHelper helper = new MySQLHelper();
        JdbcTemplate jdbcTemplate = helper.connectDbOpDb();
        String sql = "UPDATE user SET user_status='"+status + " 'WHERE user_name='" + userName + "'";
        System.out.println(sql);
        jdbcTemplate.update(sql);
        return Rets.success();
    }

}
