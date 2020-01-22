package com.epam.homework.university.models;

import com.epam.homework.helpers.Helper;

import java.text.DecimalFormat;

public class Faculty {
    private String name;
    private Group[] groups;

    public String getName() {
        return name;
    }

    public Group[] getGroups() {
        return groups;
    }

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty(String name, Group[] groups) {
        this.name = name;
        Helper.validateArray(groups, "Faculty "+ name + " doesn't have any groups");
        this.groups = groups;
    }

    public Group[] addGroup(Group group){
        Helper.validateArray(groups, "Faculty "+ name + " doesn't have any groups");
        if (getGroup(group.getName()) != null){
            throw new RuntimeException("Faculty "+ name + " already has group named " + group.getName());
        }else{
            groups = (Group[]) Helper.extendArray(groups,group);
        }
        return groups;
    }

    public Group getGroup(String name){
        Helper.validateArray(groups, "Faculty "+ name + " doesn't have any groups");
        for (Group group : groups) {
            if (group.getName().equals(name)){
                return group;
            }
        }
        return null;
    }

    public double getAverageScoreBySubject(String subject){
        double total = 0;
        for (Group group : groups) {
            total += group.getAverageScoreBySubject(subject);
        }
        return Double.parseDouble(new DecimalFormat("#.##").format(total/groups.length));
    }
}
