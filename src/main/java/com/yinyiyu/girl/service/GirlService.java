package com.yinyiyu.girl.service;

import com.yinyiyu.girl.domain.Girl;
import com.yinyiyu.girl.enums.ResultEnum;
import com.yinyiyu.girl.exception.GirlException;
import com.yinyiyu.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if(age<10){
            //返回：你还在上小学吧 code:100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10&&age<16){
            //返回：你可能还在上初中吧code；101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        //如果大于16岁，加钱
        //..
    }

    /**
     * 通过id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findById(id).get();
    }

}
