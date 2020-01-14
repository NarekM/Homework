package com.epam.homework.university;

import com.epam.homework.university.models.Faculty;
import com.epam.homework.university.models.Group;
import com.epam.homework.university.models.Course;
import com.epam.homework.university.models.Student;

public class Helper {
    public static Object[] extendArray(Object[] arr, Object item){
        Object[] temp = null;
        if (arr[0] instanceof Faculty && item instanceof Faculty){
            temp = new Faculty[arr.length + 1];
        } else if (arr[0] instanceof Group && item instanceof Group){
            temp = new Group[arr.length + 1];
        } else if (arr[0] instanceof Student && item instanceof Student){
            temp = new Student[arr.length + 1];
        } else if (arr[0] instanceof Course && item instanceof Course){
            temp = new Course[arr.length + 1];
        }
        if (temp != null){
            for (int i = 0; i < temp.length -1; i++) {
                temp[i] = arr[i];
            }
            temp[arr.length] = item;
        }
        return temp;
    }
}
