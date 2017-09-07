JAVA Programing
----------------------------------------------------
#### 2017.09.07 4일차

###### 예제
____________________________________________________

###### 공부내용
____________________________________________________

  - Array(배열)

    변수는 하나의 데이터만 저장할 수 있다. 따라서 저장해야 할 데이터의 수가 많아지면 그만큼 변수가 필요하다.
    이러한 방법을 해결하고자 만든 방법이 배열이다. 배열은 같은 타입의 데이터를 연속된 공간에 나열시키고, 각 데이터에 index를 부여해 놓은 자료구조이다.

    - 배열의 선언

      ```java
      /*
       * 기본적인 배열 선언 ( 배열 생성은 되지 않음 )
       * Type 이름[] or Type[] 이름;
       * 배열을 생성하려면 new Type 이름[배열크기]; 연산자를 사용해야 한다.
       *
       * 값 목록으로 배열 선언 ( 배열 생성이 됨 )
       * Type 이름 = {타입변수1,타입변수1,타입변수3... }
       *
       */
       int intArray[] = new int[10];
       /*
        * 기본형인 int, long 등과 같은 타입들은 공간은 할당하는 것 만으로도 default 값이 넣어진다.
        */
       System.out.println(intArray[7]);
       // 출력 : 0

       /*
        * 하지만 커스텀 타입 배열들은 할당이 되지 않는다.
        * 그래서 new 연산자를 통해 할당을 해줘야 한다.
        */
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

  - 제네릭(Generic)

    - 제네릭(Generic)이란?

      - 제네릭(Generic)은 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법을 의미한다.

      - 제네릭(Generic)은 컴파일 시 강한 타입 체크를 할 수 있고, 타입 변환(Casting)을 제거하기 때문에 사용해야 한다.

        ```java
        List list = new ArrayList();
        list.add("Hello");
        String str = (String)list.get(0);       //타입 변환을 해줘야 한다.

        List<String> list = new ArrayList<String>();
        list.add("Hello");
        String str = list.get(0);               //타입 변환을 하지 않는다.

        ```

    - 제네릭(Generic) 사용 방법

      ![Generic](https://github.com/Hooooong/DAY4_Collections/blob/master/image/Generic.png)  

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

      /*
       * 또한, 클래스와 인터페이스를 생성할 시에도 제네릭 타입을 사용할 수 있다.
       */
       public class Person<T>{
         private T t;
         private T get();
         private void set(T t);
       }

       // 타입 파라메터를 String 으로 변경할 시
       // 컴파일에서 자동으로 T 를 String 으로 변경해준다.
       Person<Stirng> person = new Person<>();

      ```

  - Collection Framework

      - Collection이란?

        > Collection이란 동적인 집합을 의미하는데, Java의 Collection은 그 대상이 바로 객체이다. 즉, JAVA의 Collection Framework이란 객체들을 모아놓고 제어, 관리 하기 위해 필요한 객체들을 모아놓은 클래스,인터페이스를 의미한다.

      - Collection Framwork의 종류( 주요 인터페이스 List, Set, Map만 알아보자 )

        ![Collections Framework](https://github.com/Hooooong/DAY4_Collections/blob/master/image/Collections%20Framework.png)

        - List 컬렉션

          index 를 포함하는 동적 객체배열. 순서를 유지하면서 저장하고, 중복저장이 가능하다.
          종류는 ArrayList, LinkedList, Vector 가 있다.

          ```java
          // List 는 설계 인터페이스이기 때문에 new 선언으로 생성할 수 없다.
          // List list = new List();

          // 선언은 일반 객체를 초기화 하는 것과 같다.
          // List<Generic Type> list = new ArrayList<>();
          List<Item> list = new ArrayList<>();

          // 입력
          list.add(new Item());       // 0번 index 로 생성
          // 입력
          list.add(1, new Item());    // 배열의 크기를 늘리고 1번 이후의 index를
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
          ```

        - Set 컬렉션

          index를 포함하고 중복값을 허용하지 않는 동적 객체배열. 순서를 유지하지 않고 저장한다.
          종류는 HashSet, TreeSet이 있다.

          ```java
          // Set 는 설계 인터페이스이기 때문에 new 선언으로 생성할 수 없다.
          // Set set = new Set();

          // 선언은 일반 객체를 초기화 하는 것과 같다.
          // Set<Generic Type> set = new HashSet<>();

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
          ```

        - Map 컬렉션

          Key, value 로 구성된 동적 객체배열. Value 는 중복이 되지만, Key 는 중복이 불가능하다.
          종류는 HashMap, HashTable, TreeMap, Properties이 있다.

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
          ```
