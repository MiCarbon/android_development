/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.monkeyrunner;

import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Application that can control an attached device using the network monkey.  It has a window
 * that shows what the current screen looks like and allows the user to click in it.  Clicking in
 * the window sends touch events to the attached device.  It also supports keyboard input for
 * typing and has buttons to press to simulate physical buttons on the device.
 */
public class MonkeyController extends JFrame {
    private static final Logger LOG = Logger.getLogger(MonkeyController.class.getName());

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    LOG.severe("Unable to sleep");
                    throw new RuntimeException(e);
                }

                DebugBridge adb = DebugBridge.createDebugBridge();
                MonkeyControllerFrame mf = new MonkeyControllerFrame(adb);
                mf.setVisible(true);
            }
        });
    }
}