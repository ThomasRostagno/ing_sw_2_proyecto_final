package com.ingsof2.utils;

import javax.swing.*;
import java.awt.*;

public class Constants {

    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public static final Dimension PANEL_DIMENSION = new Dimension(WIDTH, HEIGHT);
    public static int X_PAD = 50;
    public static int Y_PAD = 30;
    public static int MARGIN = 20;
    public static String EMPTY_COMBOBOX = "";
    public static String BACKGROUND = "./pictures/background.jpg";
    public static String BANNER_MAIN_PANEL = "./pictures/banner-main-panel.jpg";
    public static int TEXTFIELD_WIDTH = 150;
    public static int TEXTFIELD_HEIGHT = 30;
    public static int CENTER_HEIGHT = HEIGHT - 36;

    public static Color RECT_COLOR = new Color(212, 212, 212, 215);

    public static boolean textValidator(JTextField textTextField) {
        try {
            String nombreYApellido = textTextField.getText();
            if (nombreYApellido.length() < 2) {
                textTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                return false;
            } else {
                textTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                return true;
            }
        } catch (Exception e) {
            textTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            return false;
        }
    }

    public static boolean dniValidator(JTextField dniTextField) {
        try {
            String dni = dniTextField.getText();
            if (dni.length() != 7 && dni.length() != 8) {
                dniTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                return false;
            } else {
                dniTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                return true;
            }
        } catch (Exception e) {
            dniTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            return false;
        }
    }

    public static boolean comboBoxValidator(JComboBox jComboBox) {
        try {
            Object value = jComboBox.getSelectedItem() != null ? jComboBox.getItemAt(jComboBox.getSelectedIndex()) : null;
            if (value instanceof String) {
                if (Utils.isNullOrEmpty(value.toString())) {
                    jComboBox.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    return false;
                }
            }
            if (value == null) {
                jComboBox.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                return false;
            } else {
                jComboBox.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                return true;
            }
        } catch (Exception e) {
            jComboBox.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            return false;
        }
    }

    public static boolean direccionValidator(JTextField direccionTextField) {
        try {
            String direccion = direccionTextField.getText();
            if (direccion.length() < 2) {
                direccionTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                return false;
            } else {
                direccionTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                return true;
            }
        } catch (Exception e) {
            direccionTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            return false;
        }
    }

    public static boolean fechaValidator(JTextField fechaTextField) {
        try {
            String fecha = fechaTextField.getText();
            if (!DateValidatorRegex.isValid(fecha)) {
                fechaTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                return false;
            } else {
                fechaTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                return true;
            }
        } catch (Exception e) {
            fechaTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            return false;
        }
    }

    public static boolean telefonoValidator(JTextField telefonoTextField) {
        try {
            String telefono = telefonoTextField.getText();
            if (telefono.length() < 10) {
                telefonoTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                return false;
            } else {
                telefonoTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                return true;
            }
        } catch (Exception e) {
            telefonoTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            return false;
        }
    }

    public static boolean emailValidator(JTextField emailTextField) {
        try {
            String email = emailTextField.getText();
            if (!EmailValidatorRegex.isValid(email)) {
                emailTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                return false;
            } else {
                emailTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                return true;
            }
        } catch (Exception e) {
            emailTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            return false;
        }
    }

    public static boolean matriculaValidator(JTextField matriculaTextField) {
        try {
            String matricula = matriculaTextField.getText();
            if (matricula.length() != 4) {
                matriculaTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                return false;
            } else {
                matriculaTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                return true;
            }
        } catch (Exception e) {
            matriculaTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            return false;
        }
    }

    public static boolean numberValidator(JTextField numberTextField) {
        try {
            int number = Utils.isNullOrEmpty(numberTextField.getText()) ? 0 : Integer.parseInt(numberTextField.getText());
            if (number < 1) {
                numberTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                return false;
            } else {
                numberTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                return true;
            }
        } catch (Exception e) {
            numberTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            return false;
        }
    }

    public static boolean percentageValidator(JTextField numberTextField) {
        try {
            int number = Utils.isNullOrEmpty(numberTextField.getText()) ? 0 : Integer.parseInt(numberTextField.getText());
            if (number < 0 || number > 100) {
                numberTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                return false;
            } else {
                numberTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                return true;
            }
        } catch (Exception e) {
            numberTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            return false;
        }
    }

    public static boolean floatValidator(JTextField numberTextField) {
        try {
            String floatNumber = numberTextField.getText();
            if (FloatValidatorRegex.isValid(floatNumber)) {
                numberTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                return false;
            } else {
                numberTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                return true;
            }
        } catch (Exception e) {
            numberTextField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            return false;
        }
    }

    public static boolean buttonValidator(JButton button) {
        try {
            if (!button.isEnabled()) {
                button.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                return false;
            } else {
                button.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                return true;
            }
        } catch (Exception e) {
            button.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            return false;
        }
    }
}
