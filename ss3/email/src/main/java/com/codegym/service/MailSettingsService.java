package com.codegym.service;

import com.codegym.entity.MailSettings;
import org.springframework.stereotype.Service;

@Service
public class MailSettingsService {
    private MailSettings settings = new MailSettings("English", 25, false, "Thor\nKing, Asgard");

    public MailSettings getSettings() {
        return settings;
    }

    public void updateSettings(MailSettings newSettings) {
        this.settings = newSettings;
    }
}
