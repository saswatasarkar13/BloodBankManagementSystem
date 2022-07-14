package com.spring.springboot.helpers;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import com.spring.springboot.common.Constants;
import com.spring.springboot.models.BloodAvailable;
import com.spring.springboot.models.BloodGroupAvailable;

public class BloodTable {

    public TreeMap<String, Integer> getBloodQuantityList(List<BloodGroupAvailable> list) {
        TreeMap<String, Integer> map = new TreeMap<>();

        for (BloodGroupAvailable item : list) {
            map.put(item.getBlood_group(), item.getQuantity());
        }

        for (String b : Constants.BLOOD_GROUPS) {
            if (!map.containsKey(b)) {
                map.put(b, 0);
            }
        }

        return map;
    }

    public HashMap<String, TreeMap<String, Integer>> getList(List<BloodAvailable> list) {

        HashMap<String, TreeMap<String, Integer>> newList = new HashMap<>();

        for (BloodAvailable item : list) {
            newList.put(item.getCity(), getBloodQuantityList(item.getBlood_groups()));
        }

        return newList;
    }

    // public TreeMap<String, Integer > getBlood(BloodAvailable obj) {

    //     TreeMap<String, Integer > newList = new TreeMap<>();

    //         newList.put(item.getCity(), getBloodQuantityList(item.getBlood_groups()));
        

    //     return newList;
    // }
}
