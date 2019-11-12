package com.iot.repository;

        import com.iot.domain.*;
        import org.springframework.data.jpa.repository.JpaRepository;

/**自定义一个接口继承JpaRepository接口，
 * 第一个参数是数据库中的某一个表名，
 * 第二个参数是主键的类型。
 * 定义好后即可使用Jpa中的方法完成对数据库的基本操作。
 * @author fuyang
 * @date 2019/10/20
 */
public interface LuckymoneyRepository extends JpaRepository<Luckymoney,Integer> {


}
