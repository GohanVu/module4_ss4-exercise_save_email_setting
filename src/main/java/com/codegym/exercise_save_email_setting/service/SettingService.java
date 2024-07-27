package com.codegym.exercise_save_email_setting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codegym.exercise_save_email_setting.model.Setting;
import com.codegym.exercise_save_email_setting.repository.ISettingRepository;
import com.codegym.exercise_save_email_setting.repository.SettingRepository;

import java.util.List;

@Service
public class SettingService implements ISettingService {
    @Autowired
    ISettingRepository settingRepository;

    @Override
    public void createSetting(Setting setting) {
        List<Setting> settingList = SettingRepository.settingList;
        Integer id = settingList.get(settingList.size()-1).getId();
        id+=1;
        setting.setId(id);
        settingRepository.createSetting(setting);
    }

    @Override
    public void updateSetting(Setting setting) {
        settingRepository.updateSetting(setting);
    }

    public Setting getSetting(Integer id){
        return settingRepository.getSetting(id);
    }

}