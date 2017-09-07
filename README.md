JAVA Programing
----------------------------------------------------
#### 2017.09.07 4일차

###### 예제
____________________________________________________

###### 공부내용
____________________________________________________

  - Array(배열)

    자료형의 집합으로 일정 공간을 할당하여 쓰이는 집합

    - 배열의 선언

      - 기본형인 int, long 타입들은 공간을 할당하는 것 만으로도 default 값이 넣어진다.
      - 하지만 커스텀 타입들은 할당이 되지 않는다.

      ```java
      /*
       * (Type 이름[] or Type[] 이름 ) = new Type[배열 크기];
       * 또는
       * Type 이름 = {타입변수1,타입변수1,타입변수3... }
       *
       */

       int intArray[] = new int[10];
       System.out.println(intArray[7]);
       // 출력 : 0

       Item itemArray[] = new Item[10];
       System.out.println(itemArray[0].getMyName());
       // 출력 : null

       // java code 규약에 따르면 배열.length 를 직접 사용하지 않는다.
       for(int i = 0; i<itemArray.length; i++) {
         itemArray[i] = new Item();
       }
       System.out.println(itemArray[0].getMyName());
       // 출력 : 지코
      ```

  - Collection

      - Collection이란?

        > Collection이란 동적인 집합을 의미하는데, Java의 Collection은 그 대상이 바로 객체이다.
   즉, JAVA의 Collection이란 객체들을 모아놓고 제어, 관리 하기 위해 필요한 객체들을 모아놓은 객체들(클래스,인터페이스)을
   의미한다.

      - Collection 의 종류

        ![Collections Framework](https://github.com/Hooooong/DAY4_Collections/blob/master/image/Collections%20Framework.png)

        - List

          index 를 포함하는 동적 객체배열. 종류는 ArrayList, LinkedList 가 있다.

          ```java
          // List 는 설계 인터페이스이기 때문에 new 선언으로 생성할 수 없다.
          // List list = new List();

          // 선언은 일반 객체를 초기화 하는 것과 같다.
          // List<Generic Type> list = new ArrayList<>();
          List<Item> list = new ArrayList<>();

          // 입력
          list.add(new Item());		   // 0번 index 로 생성
          list.add(new Item());		   // 1번 index로 생성

          // 입력
          list.add(1, new Item());		// 배열의 크기를 늘리고 1번 이후의 index를
                                          // 하나씩 증가시킨 후 1번 자리로 들어가게 된다.

          // 출력
          list.get(0);					// 0번 index 출력
          list.get(1);					// 1번 index 출력'

          // 또다른 입력
          list.set(0, new Item());		// 0번 index를 삭제하고 새로운 new Item() 으로 대체힌다.

          // 삭제
          list.remove(1);				// 삭제할 아이템의 index를 지정한다. index를 삭제하고, 그 뒤에 아이템들을 한칸씩 이동해서 빈공간을 채운다.
          ```

        - Set

          index를 포함하고 중복값을 허용하지 않는 동적 객체배열. 종류는 HashSet, TreeSet이 있다.

          ```java
          // Set 는 설계 인터페이스이기 때문에 new 선언으로 생성할 수 없다.
          // Set set = new Set();

          // 선언은 일반 객체를 초기화 하는 것과 같다.
          // Set<Generic Type> set = new HashSet<>();

          Set<String> set = new HashSet<>();

          // 입력
          set.add("봉봉1");
          set.add("봉봉2");
          set.add("봉봉3");
          set.add("봉봉4");

          /*
           * 출력 1
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
           * 출력 2
           *
           * 향상된 For 문으로 출력 가능
           */
          for(String item : set) {
            System.out.println(item);
          }

          //삭제
          set.remove("봉봉1");
          ```

        - Map

          Key, value 로 구성된 동적 객체배열. Value 는 중복이 되지만, Key 는 중복이 불가능하다. 종류는 HashMap, TreeMap이 있다.

          ```java
          // Map 는 설계 인터페이스이기 때문에 new 선언으로 생성할 수 없다.
          // Map map = new Map();

          // 선언은 일반 객체를 초기화 하는 것과 같다.
          // Map<Generic Type, Generic Type> map = new HashMap<>();

          Map<Integer ,String> map = new HashMap<>();

          // 입력
          map.put(1, "이흥기");
          map.put(2, "김철");
          map.put(3, "임수빈");

          /*
           * 출력 1(단일)
           *
           * map객체.get(Key Type)
           * RETURN : valueType
           */
          System.out.println(map.get(1));

          /*
           * 출력 2(다중)
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
          ```

  - Generic

    ![Generic](https://github.com/Hooooong/DAY4_Collections/blob/master/image/Generic.png)

    - 제네릭(Generic)은 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법을 의미한다.

    - Generic 을 사용하는 이유는 타입의 안정성과 코드 중복 제거의 문제해결을 위해서 사용한다.

      ```java
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
      TreeSet<Integer> treeSet = new TreeSet<>();
      HashMap<Person> hashMap = new HashMap<>();

      // 다양하게 사용할 수 있다.
      ```
