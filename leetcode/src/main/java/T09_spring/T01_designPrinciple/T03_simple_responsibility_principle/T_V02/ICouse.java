package T09_spring.T01_designPrinciple.T03_simple_responsibility_principle.T_V02;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/23 06:31
 * @description
 * @editUser hx1098
 * @editTime 2022/9/23 06:31
 * @editDescription  版本03
 */
public interface ICouse {

    /**
     * 获取基本信息
     * @return
     */
    String getCourseName();

    /**
     * 视频流
     *
     * @return
     */
    byte[] getCourseVideo();



}
