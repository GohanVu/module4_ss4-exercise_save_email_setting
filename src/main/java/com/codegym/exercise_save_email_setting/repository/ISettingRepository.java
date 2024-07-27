package com.codegym.exercise_save_email_setting.repository;

import com.codegym.exercise_save_email_setting.model.Setting;

import java.util.List;

public interface ISettingRepository {
    void createSetting(Setting setting);
    void updateSetting(Setting setting);
    Setting getSetting(Integer id);
}