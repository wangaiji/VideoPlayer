package com.example.module_home.data;

import java.util.List;

public class VideoMessage {

    /**
     * resultCode : 1
     * resultMsg : success
     * reqId : b43f3521-14e5-4d26-915f-489721164143
     * systemTime : 1570268022999
     * areaList : [{"area_id":"101001","expInfo":{"algorighm_exp_id":"","front_exp_id":"0","s_value":"4b607679-7064-432c-aed0-18a7819a9d15_29224653765970511"}},{"area_id":"101002","expInfo":{"algorighm_exp_id":"0","front_exp_id":"0","s_value":"0"}}]
     * categoryInfo : {"categoryId":"4","name":"娱乐","color":"#E966AE"}
     * nextUrl : http://app.pearvideo.com/clt/jsp/v2/getCategoryConts.jsp?categoryId=4&start=10
     * hotList : [{"contId":"1609041","name":"那些组合的成名歌曲你都听过多少？","pic":"http://image2.pearvideo.com/cont/20191004/cont-1609041-12151082.jpg","nodeInfo":{"nodeId":"3174","name":"偶像请回答","logoImg":"http://image2.pearvideo.com/node/3174-11904158-logo.png"},"link":"http://","linkType":"0","cornerLabel":"","cornerLabelDesc":"","forwordType":"1","videoType":"1","duration":"02'28\"","liveStatus":"","liveStartTime":"","praiseTimes":"0"},{"contId":"1608505","name":"吃货小胖子，教你垃圾分类小秘诀！","pic":"http://image1.pearvideo.com/cont/20191001/10443088-150729-1.png","nodeInfo":{"nodeId":"752","name":"这班挺有闹","logoImg":"http://image.pearvideo.com/node/752-12142992-logo.png"},"link":"http://","linkType":"0","cornerLabel":"","cornerLabelDesc":"","forwordType":"1","videoType":"1","duration":"00'52\"","liveStatus":"","liveStartTime":"","praiseTimes":"84"},{"contId":"1607269","name":"从阿宝到大毛：卡通里的中国形象","pic":"http://image.pearvideo.com/cont/20190927/cont-1607269-12144582.jpeg","nodeInfo":{"nodeId":"18","name":"文娱小队长","logoImg":"http://image1.pearvideo.com/node/18-10027897-logo.jpg"},"link":"http://","linkType":"0","cornerLabel":"","cornerLabelDesc":"","forwordType":"1","videoType":"1","duration":"02'27\"","liveStatus":"","liveStartTime":"","praiseTimes":"72"}]
     * contList : [{"contId":"1609132","name":"我和我的祖国登英国院线好评榜首","pic":"http://image.pearvideo.com/cont/20191005/cont-1609132-12151434.jpg","nodeInfo":{"nodeId":"10","name":"时差视频","logoImg":"http://image1.pearvideo.com/node/10-10027909-logo.jpg"},"link":"http://","linkType":"0","cornerLabel":"","cornerLabelDesc":"","forwordType":"1","videoType":"1","duration":"00'59\"","liveStatus":"","liveStartTime":"","praiseTimes":"0"},{"contId":"1608948","name":"《广寒宫》舞蹈镜面分解教学part4","pic":"http://image2.pearvideo.com/cont/20191004/10887340-134550-1.png","nodeInfo":{"nodeId":"1348","name":"口袋舞蹈君","logoImg":"http://image2.pearvideo.com/node/1348-10450919-logo.png"},"link":"http://","linkType":"0","cornerLabel":"","cornerLabelDesc":"","forwordType":"1","videoType":"1","duration":"05'56\"","liveStatus":"","liveStartTime":"","praiseTimes":"0"},{"contId":"1608883","name":"《我和我的祖国》海外上映反响热烈","pic":"http://image2.pearvideo.com/cont/20191003/cont-1608883-12150491.png","nodeInfo":{"nodeId":"963","name":"全球拍","logoImg":"http://image1.pearvideo.com/node/963-10317772-logo.png"},"link":"http://","linkType":"0","cornerLabel":"3","cornerLabelDesc":"独播","forwordType":"1","videoType":"1","duration":"02'27\"","liveStatus":"","liveStartTime":"","praiseTimes":"1311"},{"contId":"1608879","name":"这些火遍大江南北的情歌你能接多少","pic":"http://image.pearvideo.com/cont/20191003/12086734-190413-1.png","nodeInfo":{"nodeId":"3174","name":"偶像请回答","logoImg":"http://image2.pearvideo.com/node/3174-11904158-logo.png"},"link":"http://","linkType":"0","cornerLabel":"","cornerLabelDesc":"","forwordType":"1","videoType":"1","duration":"02'21\"","liveStatus":"","liveStartTime":"","praiseTimes":"3"},{"contId":"1605335","name":"万茜：用小号默默关注了很多漫画家","pic":"http://image2.pearvideo.com/cont/20190923/cont-1605335-12138200.jpg","nodeInfo":{"nodeId":"18","name":"文娱小队长","logoImg":"http://image1.pearvideo.com/node/18-10027897-logo.jpg"},"link":"http://","linkType":"0","cornerLabel":"","cornerLabelDesc":"","forwordType":"1","videoType":"1","duration":"02'56\"","liveStatus":"","liveStartTime":"","praiseTimes":"399"},{"contId":"1605500","name":"蔡明：所有人都误会了！我不爱吐槽","pic":"http://image.pearvideo.com/cont/20190923/cont-1605500-12138684.jpg","nodeInfo":{"nodeId":"18","name":"文娱小队长","logoImg":"http://image1.pearvideo.com/node/18-10027897-logo.jpg"},"link":"http://","linkType":"0","cornerLabel":"","cornerLabelDesc":"","forwordType":"1","videoType":"1","duration":"02'50\"","liveStatus":"","liveStartTime":"","praiseTimes":"103"},{"contId":"1608803","name":"DFD赛事分队舞蹈串烧，爆发十足","pic":"http://image1.pearvideo.com/cont/20191003/10887340-150746-1.png","nodeInfo":{"nodeId":"1348","name":"口袋舞蹈君","logoImg":"http://image2.pearvideo.com/node/1348-10450919-logo.png"},"link":"http://","linkType":"0","cornerLabel":"","cornerLabelDesc":"","forwordType":"1","videoType":"1","duration":"02'43\"","liveStatus":"","liveStartTime":"","praiseTimes":"0"}]
     */

    private String resultCode;
    private String resultMsg;
    private String reqId;
    private String systemTime;
    private CategoryInfoBean categoryInfo;
    private String nextUrl;
    private List<AreaListBean> areaList;
    private List<HotListBean> hotList;
    private List<ContListBean> contList;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime;
    }

    public CategoryInfoBean getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfoBean categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public List<AreaListBean> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<AreaListBean> areaList) {
        this.areaList = areaList;
    }

    public List<HotListBean> getHotList() {
        return hotList;
    }

    public void setHotList(List<HotListBean> hotList) {
        this.hotList = hotList;
    }

    public List<ContListBean> getContList() {
        return contList;
    }

    public void setContList(List<ContListBean> contList) {
        this.contList = contList;
    }

    public static class CategoryInfoBean {
        /**
         * categoryId : 4
         * name : 娱乐
         * color : #E966AE
         */

        private String categoryId;
        private String name;
        private String color;

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public static class AreaListBean {
        /**
         * area_id : 101001
         * expInfo : {"algorighm_exp_id":"","front_exp_id":"0","s_value":"4b607679-7064-432c-aed0-18a7819a9d15_29224653765970511"}
         */

        private String area_id;
        private ExpInfoBean expInfo;

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public ExpInfoBean getExpInfo() {
            return expInfo;
        }

        public void setExpInfo(ExpInfoBean expInfo) {
            this.expInfo = expInfo;
        }

        public static class ExpInfoBean {
            /**
             * algorighm_exp_id :
             * front_exp_id : 0
             * s_value : 4b607679-7064-432c-aed0-18a7819a9d15_29224653765970511
             */

            private String algorighm_exp_id;
            private String front_exp_id;
            private String s_value;

            public String getAlgorighm_exp_id() {
                return algorighm_exp_id;
            }

            public void setAlgorighm_exp_id(String algorighm_exp_id) {
                this.algorighm_exp_id = algorighm_exp_id;
            }

            public String getFront_exp_id() {
                return front_exp_id;
            }

            public void setFront_exp_id(String front_exp_id) {
                this.front_exp_id = front_exp_id;
            }

            public String getS_value() {
                return s_value;
            }

            public void setS_value(String s_value) {
                this.s_value = s_value;
            }
        }
    }

    public static class HotListBean {
        /**
         * contId : 1609041
         * name : 那些组合的成名歌曲你都听过多少？
         * pic : http://image2.pearvideo.com/cont/20191004/cont-1609041-12151082.jpg
         * nodeInfo : {"nodeId":"3174","name":"偶像请回答","logoImg":"http://image2.pearvideo.com/node/3174-11904158-logo.png"}
         * link : http://
         * linkType : 0
         * cornerLabel :
         * cornerLabelDesc :
         * forwordType : 1
         * videoType : 1
         * duration : 02'28"
         * liveStatus :
         * liveStartTime :
         * praiseTimes : 0
         */

        private String contId;
        private String name;
        private String pic;
        private NodeInfoBean nodeInfo;
        private String link;
        private String linkType;
        private String cornerLabel;
        private String cornerLabelDesc;
        private String forwordType;
        private String videoType;
        private String duration;
        private String liveStatus;
        private String liveStartTime;
        private String praiseTimes;

        public String getContId() {
            return contId;
        }

        public void setContId(String contId) {
            this.contId = contId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public NodeInfoBean getNodeInfo() {
            return nodeInfo;
        }

        public void setNodeInfo(NodeInfoBean nodeInfo) {
            this.nodeInfo = nodeInfo;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getLinkType() {
            return linkType;
        }

        public void setLinkType(String linkType) {
            this.linkType = linkType;
        }

        public String getCornerLabel() {
            return cornerLabel;
        }

        public void setCornerLabel(String cornerLabel) {
            this.cornerLabel = cornerLabel;
        }

        public String getCornerLabelDesc() {
            return cornerLabelDesc;
        }

        public void setCornerLabelDesc(String cornerLabelDesc) {
            this.cornerLabelDesc = cornerLabelDesc;
        }

        public String getForwordType() {
            return forwordType;
        }

        public void setForwordType(String forwordType) {
            this.forwordType = forwordType;
        }

        public String getVideoType() {
            return videoType;
        }

        public void setVideoType(String videoType) {
            this.videoType = videoType;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getLiveStatus() {
            return liveStatus;
        }

        public void setLiveStatus(String liveStatus) {
            this.liveStatus = liveStatus;
        }

        public String getLiveStartTime() {
            return liveStartTime;
        }

        public void setLiveStartTime(String liveStartTime) {
            this.liveStartTime = liveStartTime;
        }

        public String getPraiseTimes() {
            return praiseTimes;
        }

        public void setPraiseTimes(String praiseTimes) {
            this.praiseTimes = praiseTimes;
        }

        public static class NodeInfoBean {
            /**
             * nodeId : 3174
             * name : 偶像请回答
             * logoImg : http://image2.pearvideo.com/node/3174-11904158-logo.png
             */

            private String nodeId;
            private String name;
            private String logoImg;

            public String getNodeId() {
                return nodeId;
            }

            public void setNodeId(String nodeId) {
                this.nodeId = nodeId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLogoImg() {
                return logoImg;
            }

            public void setLogoImg(String logoImg) {
                this.logoImg = logoImg;
            }
        }
    }

    public static class ContListBean {
        /**
         * contId : 1609132
         * name : 我和我的祖国登英国院线好评榜首
         * pic : http://image.pearvideo.com/cont/20191005/cont-1609132-12151434.jpg
         * nodeInfo : {"nodeId":"10","name":"时差视频","logoImg":"http://image1.pearvideo.com/node/10-10027909-logo.jpg"}
         * link : http://
         * linkType : 0
         * cornerLabel :
         * cornerLabelDesc :
         * forwordType : 1
         * videoType : 1
         * duration : 00'59"
         * liveStatus :
         * liveStartTime :
         * praiseTimes : 0
         */

        private String contId;
        private String name;
        private String pic;
        private NodeInfoBeanX nodeInfo;
        private String link;
        private String linkType;
        private String cornerLabel;
        private String cornerLabelDesc;
        private String forwordType;
        private String videoType;
        private String duration;
        private String liveStatus;
        private String liveStartTime;
        private String praiseTimes;

        public String getContId() {
            return contId;
        }

        public void setContId(String contId) {
            this.contId = contId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public NodeInfoBeanX getNodeInfo() {
            return nodeInfo;
        }

        public void setNodeInfo(NodeInfoBeanX nodeInfo) {
            this.nodeInfo = nodeInfo;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getLinkType() {
            return linkType;
        }

        public void setLinkType(String linkType) {
            this.linkType = linkType;
        }

        public String getCornerLabel() {
            return cornerLabel;
        }

        public void setCornerLabel(String cornerLabel) {
            this.cornerLabel = cornerLabel;
        }

        public String getCornerLabelDesc() {
            return cornerLabelDesc;
        }

        public void setCornerLabelDesc(String cornerLabelDesc) {
            this.cornerLabelDesc = cornerLabelDesc;
        }

        public String getForwordType() {
            return forwordType;
        }

        public void setForwordType(String forwordType) {
            this.forwordType = forwordType;
        }

        public String getVideoType() {
            return videoType;
        }

        public void setVideoType(String videoType) {
            this.videoType = videoType;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getLiveStatus() {
            return liveStatus;
        }

        public void setLiveStatus(String liveStatus) {
            this.liveStatus = liveStatus;
        }

        public String getLiveStartTime() {
            return liveStartTime;
        }

        public void setLiveStartTime(String liveStartTime) {
            this.liveStartTime = liveStartTime;
        }

        public String getPraiseTimes() {
            return praiseTimes;
        }

        public void setPraiseTimes(String praiseTimes) {
            this.praiseTimes = praiseTimes;
        }

        public static class NodeInfoBeanX {
            /**
             * nodeId : 10
             * name : 时差视频
             * logoImg : http://image1.pearvideo.com/node/10-10027909-logo.jpg
             */

            private String nodeId;
            private String name;
            private String logoImg;

            public String getNodeId() {
                return nodeId;
            }

            public void setNodeId(String nodeId) {
                this.nodeId = nodeId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLogoImg() {
                return logoImg;
            }

            public void setLogoImg(String logoImg) {
                this.logoImg = logoImg;
            }
        }
    }

    @Override
    public String toString() {
        return "VideoMessage{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", reqId='" + reqId + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", categoryInfo=" + categoryInfo +
                ", nextUrl='" + nextUrl + '\'' +
                ", areaList=" + areaList +
                ", hotList=" + hotList +
                ", contList=" + contList +
                '}';
    }
}
