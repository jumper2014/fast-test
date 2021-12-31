package cn.enilu.flash.api.factory;

import cn.enilu.flash.bean.dto.WrkflowDTO;
import cn.enilu.flash.bean.entity.atool.ApsWrkFlw;
import org.springframework.beans.BeanUtils;

/**
 * 用户创建工厂
 *
 * @author fengshuonan
 * @date 2017-05-05 22:43
 */
public class WrkFlowFactory {

    public static ApsWrkFlw createWrkFlow(WrkflowDTO wrkflowDTO, ApsWrkFlw apsWrkFlw) {
        if (wrkflowDTO == null) {
            return null;
        } else {
            BeanUtils.copyProperties(wrkflowDTO, apsWrkFlw);
            return apsWrkFlw;
        }
    }

//    public static User updateUser(UserDto userDto, User user) {
//        if (userDto == null) {
//            return null;
//        } else {
//            user.setName(userDto.getName());
//            user.setDeptid(userDto.getDeptid());
//            user.setSex(userDto.getSex());
//            user.setPhone(userDto.getPhone());
//            user.setEmail(userDto.getEmail());
//            user.setBirthday(userDto.getBirthday());
//            if (userDto.getStatus() != null) {
//                user.setStatus(userDto.getStatus());
//            }
//            return user;
//        }
//    }
}
