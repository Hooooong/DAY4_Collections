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
	 * 배열에 관한 메소드
	 * 선언 
	 * (Type 이름[] or Type[] 이름 ) = new Type[배열 크기];
	 *
	 * 기본형인 int, long 타입들은 공간을 할당하는 것만으로도 default값이 넣어진다.
	 * 
	 * 하지만  커스텀 타입들은 할당이 되지 않는다.
	 * 배열 앞에 new 는 번짓수만 만들어 주기 때문에 new Type()을 선언해야 한다.
	 * 
	 */
	public void checkArray() {
		
		int intArray[] = new int[10];
		System.out.println(intArray[7]);
		
		Item itemArray[] = new Item[10];
		System.out.println(itemArray[0].getMyName());
		
		// java code 규약에 따르면 배열.length 를 직접 사용하지 않는다.
		int itemLenth = itemArray.length;
		for(int i = 0; i<itemLenth; i++) {
			itemArray[i] = new Item();
		}
		System.out.println(itemArray[0].getMyName());

	}
	
	/**
	 * index 를 포함하는 동적 객체배열
	 */
	public void checkList() {
		// List 는 설계 인터페이스이기 때문에 new 선언으로 생성할 수 없다.
		// List list = new List();
		
		// 선언은 일반 객체를 초기화 하는 것과 같다.
		// List<Generic Type> list = new ArrayList<>();
		// 종류는 ArrayList, LinkedList 가 있다.
		List<Item> list = new ArrayList<>();
		
		// 입력
        list.add(new Item());     	// 0번 index 로 생성
        // 입력
        list.add(1, new Item());  	// 배열의 크기를 늘리고 1번 이후의 index를
                                  	// 하나씩 증가시킨 후 1번 자리로 들어가게 된다.
        // 입력
        list.set(0, new Item());	// 0번 index를 삭제하고 새로운 new Item() 으로 대체힌다.

        // 검색
        list.get(0);      // 0번 index 출력
        // 검색
        list.size();      // list 의 길이 출력
        // 검색
        list.isEmpty();   // list가 비어있는지 여부

        // 삭제
        list.remove(0);   // 삭제할 아이템의 index를 지정한다. index를 삭제하고, 그 뒤에 아이템들을 한칸씩 이동해서 빈공간을 채운다.
        // 삭제
        list.clear();     // list 전체 삭제
										
	}
	
	/**
	 * index를 포함하고 중복값을 허용하지 않는 동적 객체배열
	 */
	public void checkSet() { 
		// Set 는 설계 인터페이스이기 때문에 new 선언으로 생성할 수 없다.
		// Set set = new Set();
		
		// 선언은 일반 객체를 초기화 하는 것과 같다.
		// Set<Generic Type> set = new HashSet<>();
		// 종류는 HashSet, TreeSet이 있다.
		
		Set<String> set = new HashSet<>();

		// 입력
        set.add("봉봉1");

        /*
         * 검색
         *
         * Iterator<Generic Type> iterator = Set객체.iterator();
         */
        Iterator<String> iterator =set.iterator();

         /*
          * set 에 값이 있는지 검사
          *
          * iterator객체.hasNext();
          * RETURN : boolean
          */
        while(iterator.hasNext()) {
        	
            /*
             * set의 값을 가져오는 메소드
             *
             * iterator객체.next();
             * RETURN : Generic Type
             */
             System.out.println(iterator.next());
        }

        /*
         * 검색
         *
         * 향상된 For 문으로 검색 가능
         */
        for(String item : set) {
          System.out.println(item);
        }

        // 검색
        set.size();          // set 의 크기를 검색
        // 검색
        set.isEmpty();       // set 이 비있는지 검색

        //삭제
        set.remove("봉봉1");  // set의 단일 객체 삭제
        // 삭제
        set.clear();         // set 전체 삭제	
	}
	
	/**
	 * Key, value 로 구성된 동적 객체배열
	 * Value 는 중복이 되지만, Key 는 중복이 불가능하다.
	 */
	public void checkMap() {
		// Map 는 설계 인터페이스이기 때문에 new 선언으로 생성할 수 없다.
		// Map map = new Map();
		
		// 선언은 일반 객체를 초기화 하는 것과 같다.
		// Map<Generic Type, Generic Type> map = new HashMap<>();
		// 종류는 HashMap, TreeMap이 있다.
		
		Map<Integer ,String> map = new HashMap<>();
		
		// 입력
        map.put(1, "이흥기");
        map.put(2, "김철");
        map.put(3, "임수빈");

        /*
         * value 검색 (단일)
         *
         * map객체.get(Key Type)
         * RETURN : valueType
         */
        System.out.println(map.get(1));

        /*
         * value 검색 (다중)
         * key를 Set객체로 받아와 Set 으로 출력
         *
         * map객체.ketSet()
         * RETURN : Set<Key Type>
         *
         */
        Set<Integer> keys = map.keySet();
        for(int key : keys) {
          System.out.println(map.get(key));
        }

        // 검색
        map.size();               // map의 총 키 갯수를 검색
        // 검색
        map.isEmpty();            // map이 비어있는지 검색
        // 검색
        map.containsKey(1);       // map에 1이란 키가 있는지 검색
        // 검색
        map.containsKey("이흥기");  // map에 이흥기 란 값이 있는지 검색

        // 삭제
        map.clear();              // map 전체 삭제
        // 삭제
        map.remove(1);            // map에 1이란 키를 삭제
        
	}

	public void checkGeneric() {
		/*
		 * Generic 을 사용하는 방법
		 * 
		 * Type<Generic Type> 변수이름;
		 * : Generic Type은 클래스만 가능하다.
		 * 
		 * 앞의 타입 옆에만 Generic Type 만 선언해줘도 된다.
		 * 
		 * 타입을 쓰지 않으면 어느 위치에 어느 타입이 들어간 지 모르기 때문에 쓰기 껄끄럽고,
		 * 향상된 for 문을 쓰기가 어렵다.
		 */
		List<String> list = new ArrayList<>();
		list.add("");
	}
	
}

class Item{
	private String myName ="지코";
	
	public String getMyName() {
		return myName;
	}
}
