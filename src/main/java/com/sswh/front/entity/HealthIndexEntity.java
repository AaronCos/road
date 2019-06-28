package com.sswh.front.entity;

/**
 * Created by wangchengcheng on 2019/6/17
 */
public class HealthIndexEntity {
    private int iid;
    private String studentId;
    private String studentName;
    private float height;  //身高cm
    private float weight;  //体重kg
    /**
     * 肺活量指数 = 肺活量 % 体表面积
     * 体量面积 = 0.0061*身高（厘米） + 0.0128*体重（kg）-0.1329
     */
    private float lungIndex;
    private float lung;
    private float faceArea;//体量面积
    private float left_eye;//眼睛视力
    private float right_eye;//眼睛视力
    private float createTime;//检查时间

    public HealthIndexEntity() {
    }

    /**
     * 通过身高体重计算体表面积
     * @param height  身高cm
     * @param weight  体重kg
     * @return 计算得到的体表面积
     */
    public Double countFaceArea(float height, float weight) {
        return 0.0061 * height + 0.0128 * weight - 0.1329;
    }

    /**
     * 获取肺活量指数
     * @param faceArea 体表面积
     * @param lung 肺活量  测试
     * @return
     */
    public Double countLungIndex(double faceArea, float lung) {
        return lung % faceArea;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getLungIndex() {
        return lungIndex;
    }

    public void setLungIndex(float lungIndex) {
        this.lungIndex = lungIndex;
    }

    public float getLung() {
        return lung;
    }

    public void setLung(float lung) {
        this.lung = lung;
    }

    public float getFaceArea() {
        return faceArea;
    }

    public void setFaceArea(float faceArea) {
        this.faceArea = faceArea;
    }

    public float getLeft_eye() {
        return left_eye;
    }

    public void setLeft_eye(float left_eye) {
        this.left_eye = left_eye;
    }

    public float getRight_eye() {
        return right_eye;
    }

    public void setRight_eye(float right_eye) {
        this.right_eye = right_eye;
    }

    public float getCreateTime() {
        return createTime;
    }

    public void setCreateTime(float createTime) {
        this.createTime = createTime;
    }
}
