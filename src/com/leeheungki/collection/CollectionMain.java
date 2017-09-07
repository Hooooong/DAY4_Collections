package com.leeheungki.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionMain {
	/**
	 * �迭�� ���� �޼ҵ�
	 * ���� 
	 * (Type �̸�[] or Type[] �̸� ) = new Type[�迭 ũ��];
	 *
	 * �⺻���� int, long Ÿ�Ե��� ������ �Ҵ��ϴ� �͸����ε� default���� �־�����.
	 * 
	 * ������  Ŀ���� Ÿ�Ե��� �Ҵ��� ���� �ʴ´�.
	 * �迭 �տ� new �� �������� ����� �ֱ� ������ new Type()�� �����ؾ� �Ѵ�.
	 * 
	 */
	public void checkArray() {
		
		int intArray[] = new int[10];
		System.out.println(intArray[7]);
		
		Item itemArray[] = new Item[10];
		System.out.println(itemArray[0].getMyName());
		
		// java code �Ծ࿡ ������ �迭.length �� ���� ������� �ʴ´�.
		int itemLenth = itemArray.length;
		for(int i = 0; i<itemLenth; i++) {
			itemArray[i] = new Item();
		}
		System.out.println(itemArray[0].getMyName());

	}
	
	/**
	 * index �� �����ϴ� ���� ��ü�迭
	 */
	public void checkList() {
		// List �� ���� �������̽��̱� ������ new �������� ������ �� ����.
		// List list = new List();
		
		// ������ �Ϲ� ��ü�� �ʱ�ȭ �ϴ� �Ͱ� ����.
		// List<Generic Type> list = new ArrayList<>();
		// ������ ArrayList, LinkedList �� �ִ�.
		List<Item> list = new ArrayList<>();
		
		// �Է�
        list.add(new Item());     	// 0�� index �� ����
        // �Է�
        list.add(1, new Item());  	// �迭�� ũ�⸦ �ø��� 1�� ������ index��
                                  	// �ϳ��� ������Ų �� 1�� �ڸ��� ���� �ȴ�.
        // �Է�
        list.set(0, new Item());	// 0�� index�� �����ϰ� ���ο� new Item() ���� ��ü����.

        // �˻�
        list.get(0);      // 0�� index ���
        // �˻�
        list.size();      // list �� ���� ���
        // �˻�
        list.isEmpty();   // list�� ����ִ��� ����

        // ����
        list.remove(0);   // ������ �������� index�� �����Ѵ�. index�� �����ϰ�, �� �ڿ� �����۵��� ��ĭ�� �̵��ؼ� ������� ä���.
        // ����
        list.clear();     // list ��ü ����
										
	}
	
	/**
	 * index�� �����ϰ� �ߺ����� ������� �ʴ� ���� ��ü�迭
	 */
	public void checkSet() { 
		// Set �� ���� �������̽��̱� ������ new �������� ������ �� ����.
		// Set set = new Set();
		
		// ������ �Ϲ� ��ü�� �ʱ�ȭ �ϴ� �Ͱ� ����.
		// Set<Generic Type> set = new HashSet<>();
		// ������ HashSet, TreeSet�� �ִ�.
		
		Set<String> set = new HashSet<>();

		// �Է�
        set.add("����1");

        /*
         * �˻�
         *
         * Iterator<Generic Type> iterator = Set��ü.iterator();
         */
        Iterator<String> iterator =set.iterator();

         /*
          * set �� ���� �ִ��� �˻�
          *
          * iterator��ü.hasNext();
          * RETURN : boolean
          */
        while(iterator.hasNext()) {
        	
            /*
             * set�� ���� �������� �޼ҵ�
             *
             * iterator��ü.next();
             * RETURN : Generic Type
             */
             System.out.println(iterator.next());
        }

        /*
         * �˻�
         *
         * ���� For ������ �˻� ����
         */
        for(String item : set) {
          System.out.println(item);
        }

        // �˻�
        set.size();          // set �� ũ�⸦ �˻�
        // �˻�
        set.isEmpty();       // set �� ���ִ��� �˻�

        //����
        set.remove("����1");  // set�� ���� ��ü ����
        // ����
        set.clear();         // set ��ü ����	
	}
	
	/**
	 * Key, value �� ������ ���� ��ü�迭
	 * Value �� �ߺ��� ������, Key �� �ߺ��� �Ұ����ϴ�.
	 */
	public void checkMap() {
		// Map �� ���� �������̽��̱� ������ new �������� ������ �� ����.
		// Map map = new Map();
		
		// ������ �Ϲ� ��ü�� �ʱ�ȭ �ϴ� �Ͱ� ����.
		// Map<Generic Type, Generic Type> map = new HashMap<>();
		// ������ HashMap, TreeMap�� �ִ�.
		
		Map<Integer ,String> map = new HashMap<>();
		
		// �Է�
        map.put(1, "�����");
        map.put(2, "��ö");
        map.put(3, "�Ӽ���");

        /*
         * value �˻� (����)
         *
         * map��ü.get(Key Type)
         * RETURN : valueType
         */
        System.out.println(map.get(1));

        /*
         * value �˻� (����)
         * key�� Set��ü�� �޾ƿ� Set ���� ���
         *
         * map��ü.ketSet()
         * RETURN : Set<Key Type>
         *
         */
        Set<Integer> keys = map.keySet();
        for(int key : keys) {
          System.out.println(map.get(key));
        }

        // �˻�
        map.size();               // map�� �� Ű ������ �˻�
        // �˻�
        map.isEmpty();            // map�� ����ִ��� �˻�
        // �˻�
        map.containsKey(1);       // map�� 1�̶� Ű�� �ִ��� �˻�
        // �˻�
        map.containsKey("�����");  // map�� ����� �� ���� �ִ��� �˻�

        // ����
        map.clear();              // map ��ü ����
        // ����
        map.remove(1);            // map�� 1�̶� Ű�� ����
        
	}

	public void checkGeneric() {
		/*
		 * Generic �� ����ϴ� ���
		 * 
		 * Type<Generic Type> �����̸�;
		 * : Generic Type�� Ŭ������ �����ϴ�.
		 * 
		 * ���� Ÿ�� ������ Generic Type �� �������൵ �ȴ�.
		 * 
		 * Ÿ���� ���� ������ ��� ��ġ�� ��� Ÿ���� �� �� �𸣱� ������ ���� ��������,
		 * ���� for ���� ���Ⱑ ��ƴ�.
		 */
		List<String> list = new ArrayList<>();
		list.add("");
	}
	
}

class Item{
	private String myName ="����";
	
	public String getMyName() {
		return myName;
	}
}
