# **Searching and Sorting Project**

## **Overview**
This project analyzes and compares the performance of various sorting and searching algorithms based on their time complexity and efficiency. It includes interactive features for testing and performance evaluation.

---

## **Project Structure**

```
src/
├── main/
│   ├── App.java
│   ├── sort/
│   │   ├── LogarithmicSort.java
│   │   ├── QuadraticSort.java
│   │   ├── SortPerformance.java
│   ├── search/
│   │   ├── LinearSearch.java
│   │   ├── BinarySearch.java
│   ├── utils/
│       ├── RandomGenerator.java
```

### **Components**
- **`App.java`**: Main entry point and user interface.
- **`sort` Package**: Implements sorting algorithms:
  - **O(n²)**: Bubble Sort, Bucket Sort.
  - **O(n*log(n))**: Merge Sort, Introsort.
- **`search` Package**: Implements searching algorithms:
  - Linear Search, Binary Search.
- **`utils` Package**: Provides random dataset generation via `RandomGenerator.java`.

---

## **Instructions to Run**
1. **Extract Files**: Download and unzip the project folder.
2. **Open in IntelliJ**:
   - Create a new project from the extracted source code.
   - Mark the `src` directory as the Sources Root.
3. **Run the Program**:
   - Navigate to `App.java`, right-click, and select **Run 'App.main()'**.
4. **Test Features**:
   - Use the menu to test sorting, searching, and performance analysis.
5. **Optional**: Export results for performance visualization (e.g., Excel charts).

---

## **Testing**
The following features are tested:
- Linear and Binary Search.
- O(n²) sorting algorithms (Bubble Sort, Bucket Sort).
- O(n*log(n)) sorting algorithms (Merge Sort, Introsort).
- Performance evaluation (time and comparison counts) for varying dataset sizes.

---

## **Author**
- **Name**: Luu Vi  
- **Email**: vi.luu@tuni.fi  

---

## **Work Summary**
- **Date**: December 14, 2024  
- **Time Spent**: 3 hours  
  - 2.5 hours: Writing and testing code.
  - 0.5 hours: Creating charts and documentation.  

--- 
