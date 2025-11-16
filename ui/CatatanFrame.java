package catatanharian.ui;

import catatanharian.model.Catatan;
import catatanharian.service.CatatanService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class CatatanFrame extends javax.swing.JPanel {

    private CatatanService service;
    private DefaultListModel<Catatan> listModel;

    public CatatanFrame() {
        initComponents();
        customizeComponents();

        service = new CatatanService();
        listModel = new DefaultListModel<>();
        jList1.setModel(listModel);

        jList1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = jList1.getSelectedIndex();
                if (index != -1) {
                    Catatan selectedCatatan = listModel.getElementAt(index);
                    if (selectedCatatan != null) {
                        jTextArea1.setText(selectedCatatan.getIsi());
                    }
                } else {
                    jTextArea1.setText("");
                }
            }
        });
        refreshList();
    }

    private void customizeComponents() {
        // Set background modern dengan gradient effect
        this.setBackground(new Color(240, 242, 245));
        
        // Styling untuk buttons dengan warna modern
        styleButton(jButton1, new Color(37, 99, 235), Color.WHITE); // Blue
        styleButton(jButton2, new Color(16, 185, 129), Color.WHITE); // Green
        styleButton(jButton3, new Color(239, 68, 68), Color.WHITE); // Red
        styleButton(jButton4, new Color(107, 114, 128), Color.WHITE); // Gray
        styleButton(jButton5, new Color(139, 92, 246), Color.WHITE); // Purple
        styleButton(jButton6, new Color(245, 158, 11), Color.WHITE); // Orange
        
        // Styling untuk List dengan background berwarna
        jList1.setBackground(new Color(224, 242, 254)); // Light blue background
        jList1.setForeground(new Color(31, 41, 55));
        jList1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jList1.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jList1.setSelectionBackground(new Color(59, 130, 246)); // Brighter blue selection
        jList1.setSelectionForeground(Color.WHITE);
        
        // Styling untuk TextArea dengan background berwarna
        jTextArea1.setBackground(new Color(254, 243, 199)); // Light yellow/cream background
        jTextArea1.setForeground(new Color(31, 41, 55));
        jTextArea1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jTextArea1.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        
        // Styling untuk ScrollPanes dengan colored border
        styleScrollPaneColored(jScrollPane2, new Color(147, 197, 253)); // Blue border
        styleScrollPaneColored(jScrollPane3, new Color(253, 224, 71)); // Yellow border
        
        // Styling untuk Labels
        jLabel1.setForeground(new Color(30, 58, 138)); // Dark blue
        jLabel2.setForeground(new Color(146, 64, 14)); // Dark orange
        jLabel3.setForeground(new Color(15, 23, 42));
        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 24));
    }
    
    private void styleButton(JButton button, Color bg, Color fg) {
        button.setBackground(bg);
        button.setForeground(fg);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(new EmptyBorder(10, 20, 10, 20));
        
        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            Color originalColor = bg;
            
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(brighten(originalColor, 0.9f));
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor);
            }
        });
    }
    
    private void styleScrollPane(JScrollPane scrollPane) {
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(229, 231, 235), 1, true),
            BorderFactory.createEmptyBorder(4, 4, 4, 4)
        ));
        scrollPane.getViewport().setBackground(Color.WHITE);
    }
    
    private void styleScrollPaneColored(JScrollPane scrollPane, Color borderColor) {
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(borderColor, 3, true),
            BorderFactory.createEmptyBorder(4, 4, 4, 4)
        ));
        // Set viewport background to match content
        scrollPane.getViewport().setBackground(scrollPane.getViewport().getView().getBackground());
    }
    
    private Color brighten(Color color, float factor) {
        int r = (int)(color.getRed() * factor);
        int g = (int)(color.getGreen() * factor);
        int b = (int)(color.getBlue() * factor);
        return new Color(Math.max(0, r), Math.max(0, g), Math.max(0, b));
    }

    private String extractTitle(String isi) {
        String[] lines = isi.split("\\n");
        String title = lines[0].trim();
        
        if (title.length() > 100) {
            title = title.substring(0, 100) + "...";
        }
        return title.isEmpty() ? "Catatan Tanpa Judul" : title;
    }
    
    private String getCurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    private void refreshList() {
        listModel.clear();
        for (Catatan c : service.getSemuaCatatan()) {
            listModel.addElement(c);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Daftar Catatan");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Isi Catatan");

        jList1.setBackground(new java.awt.Color(153, 255, 255));
        jScrollPane1.setViewportView(jList1);

        jScrollPane2.setViewportView(jScrollPane1);

        jTextArea1.setBackground(new java.awt.Color(153, 204, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jScrollPane3.setViewportView(jScrollPane4);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("TAMBAH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("UBAH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("HAPUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("CLEAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("IMPORT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setText("EXPORT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Catatan Harian");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(107, 107, 107)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(34, 34, 34)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(397, 397, 397)
                        .addComponent(jLabel3)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String isiLengkap = jTextArea1.getText().trim();

        if (isiLengkap.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi catatan tidak boleh kosong!");
            return;
        }

        String judul = extractTitle(isiLengkap);
        String tanggal = getCurrentDateTime();
        
        Catatan c = new Catatan(judul, isiLengkap, tanggal);
        
        service.tambahCatatan(c);
        listModel.addElement(c);

        jTextArea1.setText("");
        JOptionPane.showMessageDialog(this, "Catatan berhasil ditambahkan: " + judul);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int index = jList1.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Pilih catatan yang ingin diubah!");
            return;
        }

        String isiBaru = jTextArea1.getText().trim();
        if (isiBaru.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi catatan tidak boleh kosong!");
            return;
        }
        
        Catatan catatanLama = listModel.getElementAt(index);

        service.ubahCatatan(index, isiBaru);
        
        String judulBaru = extractTitle(isiBaru);
        String tanggalBaru = getCurrentDateTime();
        
        catatanLama.setJudul(judulBaru);
        catatanLama.setIsi(isiBaru);
        catatanLama.setTanggal(tanggalBaru);

        listModel.set(index, catatanLama);

        JOptionPane.showMessageDialog(this, "Catatan berhasil diubah: " + judulBaru);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      int index = jList1.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Pilih catatan yang ingin dihapus!");
            return;
        }

        service.hapusCatatan(index);
        listModel.remove(index);
        jTextArea1.setText("");
        JOptionPane.showMessageDialog(this, "Catatan berhasil dihapus!");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         jList1.clearSelection();
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));
        fc.addChoosableFileFilter(new FileNameExtensionFilter("PDF Files (*.pdf)", "pdf"));
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));
        fc.setAcceptAllFileFilterUsed(true);

        int hasil = fc.showOpenDialog(this);

        if (hasil == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            
            FileNameExtensionFilter filter = (FileNameExtensionFilter) fc.getFileFilter();
            String extension = "";
            if (filter != null && filter.getExtensions().length > 0) {
                extension = filter.getExtensions()[0];
            } else {
                String fileName = file.getName().toLowerCase();
                if (fileName.endsWith(".txt")) extension = "txt";
                else if (fileName.endsWith(".pdf")) extension = "pdf";
                else if (fileName.endsWith(".xlsx")) extension = "xlsx";
            }
            
            try {
                if (extension.equalsIgnoreCase("txt")) {
                    importFromTextFile(file);
                } else if (extension.equalsIgnoreCase("pdf")) {
                    importFromPdf(file);
                } else if (extension.equalsIgnoreCase("xlsx")) {
                    importFromExcel(file);
                } else {
                    JOptionPane.showMessageDialog(this, "Format file tidak didukung atau tidak dapat dideteksi!");
                    return;
                }
                
                refreshList();
                JOptionPane.showMessageDialog(this, "Import berhasil dari file!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Gagal import file: Error I/O " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal import file: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Text File (*.txt)", "txt"));
        fc.addChoosableFileFilter(new FileNameExtensionFilter("PDF File (*.pdf)", "pdf"));
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Excel File (*.xlsx)", "xlsx"));
        fc.setAcceptAllFileFilterUsed(true);

        int hasil = fc.showSaveDialog(this);

        if (hasil == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            
            FileNameExtensionFilter filter = (FileNameExtensionFilter) fc.getFileFilter();
            String extension = filter.getExtensions()[0];

            if (!file.getName().toLowerCase().endsWith("." + extension)) {
                file = new File(file.toString() + "." + extension);
            }
            
            try {
                if (extension.equalsIgnoreCase("txt")) {
                    exportToTextFile(file);
                } else if (extension.equalsIgnoreCase("pdf")) {
                    exportToPdf(file);
                } else if (extension.equalsIgnoreCase("xlsx")) {
                    exportToExcel(file);
                } else {
                    JOptionPane.showMessageDialog(this, "Format file tidak didukung!");
                    return;
                }
                JOptionPane.showMessageDialog(this, "Export berhasil disimpan!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Gagal export file: Error I/O " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal export file: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton6ActionPerformed
   // --- Metode Implementasi Import/Export ---

    private void importFromTextFile(File file) throws IOException {
        service.getSemuaCatatan().clear();
        listModel.clear();
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                if (!baris.trim().isEmpty()) {
                    String isi = baris;
                    String judul = extractTitle(isi);
                    String tanggal = getCurrentDateTime();
                    
                    Catatan c = new Catatan(judul, isi, tanggal);
                    service.tambahCatatan(c);
                }
            }
        }
    }
    
    private void exportToTextFile(File file) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            List<Catatan> semuaCatatan = service.getSemuaCatatan();
            for (int i = 0; i < semuaCatatan.size(); i++) {
                Catatan c = semuaCatatan.get(i);
                bw.write(c.getIsi());
                if (i < semuaCatatan.size() - 1) {
                    bw.newLine();
                }
            }
        }
    }
    
    // --- Skeleton untuk PDF dan Excel ---
    
  private void importFromPdf(File file) throws Exception {
        JOptionPane.showMessageDialog(this, "Import dari PDF memerlukan library pihak ketiga.", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
    
    private void exportToPdf(File file) throws Exception {
        JOptionPane.showMessageDialog(this, "Export ke PDF memerlukan library pihak ketiga.", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
    
    private void importFromExcel(File file) throws Exception {
        JOptionPane.showMessageDialog(this, "Import dari Excel memerlukan library pihak ketiga.", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }

    private void exportToExcel(File file) throws Exception {
        JOptionPane.showMessageDialog(this, "Export ke Excel memerlukan library pihak ketiga.", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<Catatan> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
