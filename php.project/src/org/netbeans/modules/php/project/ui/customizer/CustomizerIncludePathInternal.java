/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.php.project.ui.customizer;

import java.awt.Component;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import org.netbeans.modules.php.project.PhpProject;
import org.netbeans.modules.php.project.classpath.BasePathSupport;
import org.netbeans.modules.php.project.ui.PathUiSupport;
import org.openide.awt.Mnemonics;
import org.openide.util.ChangeSupport;
import org.openide.util.NbBundle;

public class CustomizerIncludePathInternal extends JPanel {

    private static final long serialVersionUID = 35465468789741L;

    private final ChangeSupport changeSupport = new ChangeSupport(this);


    CustomizerIncludePathInternal(PhpProject project, DefaultListModel<BasePathSupport.Item> includePathListModel,
            ListCellRenderer<BasePathSupport.Item> includePathListRenderer, String lastFolderKey) {
        assert project != null;
        assert includePathListModel != null;
        assert includePathListRenderer != null;
        assert lastFolderKey != null;

        initComponents();
        init(project, includePathListModel, includePathListRenderer, lastFolderKey);
    }

    private void init(PhpProject project, DefaultListModel<BasePathSupport.Item> includePathListModel,
            ListCellRenderer<BasePathSupport.Item> includePathListRenderer, final String lastFolderKey) {
        PathUiSupport.EditMediator.FileChooserDirectoryHandler directoryHandler = new PathUiSupport.EditMediator.FileChooserDirectoryHandler() {
            @Override
            public String getDirKey() {
                return lastFolderKey;
            }
            @Override
            public File getCurrentDirectory() {
                return null;
            }
        };
        includePathList.setModel(includePathListModel);
        includePathList.setCellRenderer(includePathListRenderer);
        includePathListModel.addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent e) {
                fireChange();
            }
            @Override
            public void intervalRemoved(ListDataEvent e) {
                fireChange();
            }
            @Override
            public void contentsChanged(ListDataEvent e) {
                fireChange();
            }
        });
        PathUiSupport.EditMediator.register(project,
                                               includePathList,
                                               addFolderButton.getModel(),
                                               removeButton.getModel(),
                                               moveUpButton.getModel(),
                                               moveDownButton.getModel(),
                                               directoryHandler);
    }

    void addChangeListener(ChangeListener listener) {
        changeSupport.addChangeListener(listener);
    }

    void removeChangeListener(ChangeListener listener) {
        changeSupport.removeChangeListener(listener);
    }

    void fireChange() {
        changeSupport.fireChange();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        includePathScrollPane = new JScrollPane();
        includePathList = new JList<BasePathSupport.Item>();
        addFolderButton = new JButton();
        removeButton = new JButton();
        moveUpButton = new JButton();
        moveDownButton = new JButton();

        includePathScrollPane.setViewportView(includePathList);

        Mnemonics.setLocalizedText(addFolderButton, NbBundle.getMessage(CustomizerIncludePathInternal.class, "CustomizerIncludePathInternal.addFolderButton.text")); // NOI18N

        Mnemonics.setLocalizedText(removeButton, NbBundle.getMessage(CustomizerIncludePathInternal.class, "CustomizerIncludePathInternal.removeButton.text")); // NOI18N

        Mnemonics.setLocalizedText(moveUpButton, NbBundle.getMessage(CustomizerIncludePathInternal.class, "CustomizerIncludePathInternal.moveUpButton.text")); // NOI18N

        Mnemonics.setLocalizedText(moveDownButton, NbBundle.getMessage(CustomizerIncludePathInternal.class, "CustomizerIncludePathInternal.moveDownButton.text")); // NOI18N

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(includePathScrollPane, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(addFolderButton, GroupLayout.Alignment.TRAILING)
                    .addComponent(removeButton, GroupLayout.Alignment.TRAILING)
                    .addComponent(moveUpButton, GroupLayout.Alignment.TRAILING)
                    .addComponent(moveDownButton, GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {addFolderButton, moveDownButton, moveUpButton, removeButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addFolderButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(moveUpButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moveDownButton))
                    .addComponent(includePathScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton addFolderButton;
    private JList<BasePathSupport.Item> includePathList;
    private JScrollPane includePathScrollPane;
    private JButton moveDownButton;
    private JButton moveUpButton;
    private JButton removeButton;
    // End of variables declaration//GEN-END:variables
}