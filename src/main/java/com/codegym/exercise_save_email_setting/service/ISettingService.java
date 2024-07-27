package com.codegym.exercise_save_email_setting.service;

import com.codegym.exercise_save_email_setting.model.Setting;

import java.util.List;

public interface ISettingService {
    void createSetting(Setting setting);
    void updateSetting(Setting setting);
    Setting getSetting(Integer id);

}