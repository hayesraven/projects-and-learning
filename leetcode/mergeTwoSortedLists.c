/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2){
    struct ListNode* listFinal = NULL;
    struct ListNode* tmp = NULL;
    
    // Check if the lists are empty
    if (list1 == NULL) {
        return list2;
    }
    else if (list2 == NULL) {
        return list1;
    }
    if (list1 == NULL && list2 == NULL) {
        return 0;
    }
    
    // Set the head
    if (list1->val <= list2->val) {
        listFinal = list1;
        list1 = list1->next;
    }
    else {
        listFinal = list2;
        list2 = list2->next;
    }
    
    tmp = listFinal;
    
    // Loop and add while both lists have nodes
    while (list1 != NULL && list2 != NULL) {
        if (list1->val <= list2->val) {
            tmp->next = list1;
            list1 = list1->next;
        }
        else {
            tmp->next = list2;
            list2 = list2->next;
        }
        tmp = tmp->next;
    }

    // Finish out list1
    while (list1 != NULL) {
        tmp->next = list1;
        list1 = list1->next;
        tmp = tmp->next;
    }
    
    // Finish out list2
    while (list2 != NULL) {
        tmp->next = list2;
        list2 = list2->next;
        tmp = tmp->next;
    }
    return listFinal;
}
