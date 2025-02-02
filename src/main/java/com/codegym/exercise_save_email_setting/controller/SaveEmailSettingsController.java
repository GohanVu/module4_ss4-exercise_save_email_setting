package com.codegym.exercise_save_email_setting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.codegym.exercise_save_email_setting.model.Setting;
import com.codegym.exercise_save_email_setting.repository.SettingRepository;
import com.codegym.exercise_save_email_setting.service.ISettingService;

import java.util.ArrayList;
import java.util.List;

import static com.codegym.exercise_save_email_setting.repository.SettingRepository.languages;
import static com.codegym.exercise_save_email_setting.repository.SettingRepository.pageSize;

@Controller

public class SaveEmailSettingsController {

    @Autowired
    ISettingService settingService;
    @RequestMapping("/settings")
    public String showIndex(Model model){
        model.addAttribute("languages", languages);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("setting", new Setting());
        return "index";
    }

    @PostMapping("settings/save")
    public String createSetting(@ModelAttribute Setting setting, RedirectAttributes redirectAttributes){
        settingService.createSetting(setting);
        redirectAttributes.addFlashAttribute("message","New setting created");
        return "redirect:/";
    }
    @GetMapping("/")
    public String showList(Model model){
        model.addAttribute("settingList",SettingRepository.settingList);
        return "list";
    }
    @GetMapping(value = "/showUpdate/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model){
        Setting setting = settingService.getSetting(id);
        model.addAttribute("setting", setting);
        model.addAttribute("languages", languages);
        model.addAttribute("pageSize", pageSize);
        return "update";
    }
    @PostMapping("/update")
    public String updateSetting(@ModelAttribute Setting setting,RedirectAttributes redirectAttributes){
        settingService.updateSetting(setting);
        redirectAttributes.addFlashAttribute("message", "Successfully updated");
        return "redirect:/";
    }


}