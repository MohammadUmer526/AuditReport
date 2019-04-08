package com.example.auditreport;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementTextPassword extends BaseFormElement {

    public FormElementTextPassword() {
    }

    public static FormElementTextPassword createInstance() {
        FormElementTextPassword FormElementTextPassword = new FormElementTextPassword();
        FormElementTextPassword.setType(BaseFormElement.TYPE_EDITTEXT_PASSWORD);
        return FormElementTextPassword;
    }

    public FormElementTextPassword setTag(int mTag) {
        return (FormElementTextPassword)  super.setTag(mTag);
    }

    public FormElementTextPassword setType(int mType) {
        return (FormElementTextPassword)  super.setType(mType);
    }

    public FormElement