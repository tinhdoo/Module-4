package com.codegym.service;

import com.codegym.entity.MailSettings;

import javax.servlet.http.HttpSession;

public interface ISettingsService {
    MailSettings getSettings(HttpSession session);
    void updateSettings(HttpSession session, MailSettings settings);
}

