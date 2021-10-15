package T05_DesignMode.T12_Command;

import T05_DesignMode.T12_Command.beExtend.RequirementGroup;

import javax.xml.crypto.dsig.keyinfo.PGPData;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/15 21:53
 * @description
 * @editUser hx
 * @editTime 2021/10/15 21:53
 * @editDescription 客户是孙子, 我们是爷爷, 孙子要啥, 老子就给啥
 */
public class Client {

    public static void main(String[] args) {

        System.out.println("首先客户要求增加一个要求...");

        Group rg = new RequirementGroup();

        /**找到需求组，进行沟通*/
        rg.find();

        /**增加应给需求*/
        rg.delete();

        /**要求变更计划*/
        rg.plan();

    }

}
