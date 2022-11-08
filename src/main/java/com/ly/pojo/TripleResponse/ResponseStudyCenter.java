package com.ly.pojo.TripleResponse;

import com.ly.pojo.ClassInfo;

import java.util.List;

public class ResponseStudyCenter {

    /**
     * finishedClazzPage : {"finishedClazzList":[{"clazzInfo":{"clazzNumber":"5988652447715840","subClazzNumber":"5988652448240129","clazzName":"B系列课B","subject":"数学"}},{"clazzInfo":{"clazzNumber":"5988473492708352","subClazzNumber":"5988473493363712","clazzName":"B分组课堂测试B","subject":"英语"}}]}
     */

    private FinishedClazzPageBean finishedClazzPage;

    public FinishedClazzPageBean getFinishedClazzPage() {
        return finishedClazzPage;
    }

    public void setFinishedClazzPage(FinishedClazzPageBean finishedClazzPage) {
        this.finishedClazzPage = finishedClazzPage;
    }

    public static class FinishedClazzPageBean {
        private List<FinishedClazzListBean> finishedClazzList;

        public List<FinishedClazzListBean> getFinishedClazzList() {
            return finishedClazzList;
        }

        public void setFinishedClazzList(List<FinishedClazzListBean> finishedClazzList) {
            this.finishedClazzList = finishedClazzList;
        }

        public static class FinishedClazzListBean {
            /**
             * clazzInfo : {"clazzNumber":"5988652447715840","subClazzNumber":"5988652448240129","clazzName":"B系列课B","subject":"数学"}
             */

            private ClassInfo clazzInfo;

            public ClassInfo getClazzInfo() {
                return clazzInfo;
            }

            public void setClazzInfo(ClassInfo clazzInfo) {
                this.clazzInfo = clazzInfo;
            }

        }
    }
}
