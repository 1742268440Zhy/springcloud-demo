package com.zhyheima.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ Description   :  自定义robbins的负载均衡算法
 * @ Author        :  张慧颖
 * @ CreateDate    :  2020/8/26 11:11
 * @ UpdateUser    :  张慧颖
 * @ UpdateDate    :  2020/8/26 11:11
 * @ UpdateRemark  :  修改内容
 * @ Version       :  1.0
 */
@Configuration
public class MySelfRule {

    /**
      * @ Describe  : 实例附在均衡算法
      * @ Author    : 张慧颖
      * @ Date      : 2020/8/26 11:12
      * @param
      * @return     :com.netflix.loadbalancer.IRule
     * com.netflix.loadbalancer.RoundRobinRule 轮询
     * com.netflix.loadbalancer.RandomRule 随机
     *  com.netflix.loadbalancer.RetryRule  先按照RoundRobinRule的策略获取服务,如果获取服务失败则在指定时间内进行重试,获取可用的服务
     *  WeightedResponseTimeRule  对RoundRobinRule的扩展,响应速度越快的实例选择权重越多大,越容易被选择
     *  BestAvailableRule  会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务,然后选择一个并发量最小的服务
     *  AvailabilityFilteringRule 先过滤掉故障实例,再选择并发较小的实例
     *  ZoneAvoidanceRule   默认规则,复合判断server所在区域的性能和server的可用性选择服务器
     **/
    @Bean
    public IRule myRule() {
        // 定义为随机
        return new RandomRule();
    }

}
