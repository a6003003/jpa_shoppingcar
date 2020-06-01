package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
@RestController
@RequestMapping("/upload")
@CrossOrigin(origins = "https://61.71.47.141:8080")//
public class Upload {

	
  

	@PostMapping
    public String upload(@RequestParam(name = "image_data", required = false) MultipartFile file) {
        String newCompanyImagepath=null;
        String filename=null;
        if (!file.isEmpty()) {
            try {
            	
            	
                Resource resource = new ClassPathResource("/");
                System.out.println("resource:"+resource);
                //String path = resource.getFile().getPath();
                
                String path="D:\\program\\vue\\line\\public\\pic";
                newCompanyImagepath = path+"\\" +nextId()+ file.getOriginalFilename();
                
                File newFile = new File(newCompanyImagepath);
                String filepath = newFile.getParent();
                filename = newFile.getName();
                System.out.println("filepath"+filepath);
                System.out.println("filename"+filename);
                System.out.println("ID"+nextId());
                
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                
                
                
                
                // ?取?出流
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "?片上?失?！";
            } catch (IOException e) {
                e.printStackTrace();
                return "?片上?失?！";
            }
            
        }
        
        newCompanyImagepath="/pic/"+filename;
        System.out.println("hahah:"+newCompanyImagepath);
        return newCompanyImagepath;
        }
	private final static long START_STMP = 1480166465631L;

    /**
     * 每一部分佔用的位數
     */
    private final static long SEQUENCE_BIT = 12; //序列號佔用的位數
    private final static long MACHINE_BIT = 5;   //機器標識佔用的位數
    private final static long DATACENTER_BIT = 5;//資料中心佔用的位數

    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    private long datacenterId;  //資料中心
    private long machineId;     //機器標識
    private long sequence = 0L; //序列號
    private long lastStmp = -1L;//上一次時間戳

    public void SnowFlake(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * 產生下一個ID
     *
     * @return
     */
    public synchronized long nextId() {
        long currStmp = getNewstmp();
        if (currStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStmp == lastStmp) {
            //相同毫秒內，序列號自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列數已經達到最大
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒內，序列號置為0
            sequence = 0L;
        }

        lastStmp = currStmp;

        return (currStmp - START_STMP) << TIMESTMP_LEFT //時間戳部分
                | datacenterId << DATACENTER_LEFT       //資料中心部分
                | machineId << MACHINE_LEFT             //機器標識部分
                | sequence;                             //序列號部分
    }

    private long getNextMill() {
        long mill = getNewstmp();
        while (mill <= lastStmp) {
            mill = getNewstmp();
        }
        return mill;
    }

    private long getNewstmp() {
        return System.currentTimeMillis();
    }

    
}

