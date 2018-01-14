import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {


    class Node {
            E value;
            Node leftChild = null;
            Node rightChild = null;
            Node(E value) {
                this.value = value;
            }
            @Override
            public boolean equals(Object obj) {
                if ((obj instanceof BinarySearchTree.Node) == false)
                    return false;
                @SuppressWarnings("unchecked")
                Node other = (BinarySearchTree<E>.Node)obj;
                return other.value.compareTo(value) == 0 &&
                        other.leftChild == leftChild && other.rightChild == rightChild;
            }
        }

        protected Node root = null;

        protected void visit(Node n) {
            System.out.println(n.value);
        }

        public boolean contains(E val) {
            return contains(root, val);
        }

        protected boolean contains(Node n, E val) {
            if (n == null) return false;

            if (n.value.equals(val)) {
                return true;
            } else if (n.value.compareTo(val) > 0) {
                return contains(n.leftChild, val);
            } else {
                return contains(n.rightChild, val);
            }
        }

        public boolean add(E val) {
            if (root == null) {
                root = new Node(val);
                return true;
            }
            return add(root, val);
        }

        protected boolean add(Node n, E val) {
            if (n == null) {
                return false;
            }
            int cmp = val.compareTo(n.value);
            if (cmp == 0) {
                return false; // this ensures that the same value does not appear more than once
            } else if (cmp < 0) {
                if (n.leftChild == null) {
                    n.leftChild = new Node(val);
                    return true;
                } else {
                    return add(n.leftChild, val);
                }
            } else {
                if (n.rightChild == null) {
                    n.rightChild = new Node(val);
                    return true;
                } else {
                    return add(n.rightChild, val);
                }
            }
        }

        public boolean remove(E val) {
            return remove(root, null, val);
        }

        protected boolean remove(Node n, Node parent, E val) {
            if (n == null) return false;

            if (val.compareTo(n.value) == -1) {
                    return remove(n.leftChild, n, val);
            } else if (val.compareTo(n.value) == 1) {
                    return remove(n.rightChild, n, val);
            } else {
                if (n.leftChild != null && n.rightChild != null){
                    n.value = maxValue(n.leftChild);
                    remove(n.leftChild, n, n.value);
                } else if (parent == null) {
                    root = n.leftChild != null ? n.leftChild : n.rightChild;
                } else if (parent.leftChild == n){
                    parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
                } else {
                    parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
                }
                return true;
            }
        }

        protected E maxValue(Node n) {
            if (n.rightChild == null) {
                return n.value;
            } else {
               return maxValue(n.rightChild);
            }
        }


        /*********************************************
         *
         * IMPLEMENT THE METHODS BELOW!
         *
         *********************************************/


        // Method #1.
        public Node findNode(E val) {

            /* IMPLEMENT THIS METHOD! */
            if(val == null)
                return null;
            if(contains(val))
            return findNode(root,val);
            else
            return null; // this line is here only so this code will compile if you don't modify it

        }

        protected Node findNode(Node n, E val)
        {

            if (n.value.equals(val)) {
                return  n;
            } else if (n.value.compareTo(val) > 0) {
                return findNode(n.leftChild, val);
            } else {
                return findNode(n.rightChild, val);
            }

        }


        // Method #2.
        protected int depth(E val) {

            /* IMPLEMENT THIS METHOD! */

            if(val == null || findNode(val) == null)
                return -1;


               int depth = 0;
               Node n = root;

               //basic case to return the root depth

               if (n.value == val) {
                   return depth;
               }

               while (!n.value.equals(val)) {
                   if (n.value.compareTo(val) > 0) {
                       n = n.leftChild;
                       depth++;
                   } else if (n.value.compareTo(val) < 0) {
                       n = n.rightChild;
                       depth++;
                   }
               }

               if (depth > 0) {
                   return depth;
               }


            return -2; // this line is here only so this code will compile if you don't modify it

        }



        // Method #3.
        protected int height(E val) {

            /* IMPLEMENT THIS METHOD! */

            Node n = findNode(val);
            int lcounter = 0;
            int rcounter = 0;

            //Goes on until find that the left or right child is null
            //keeps increasing the counter

            if(n != null)
            {
                while(n.leftChild != null) {
                    n = n.leftChild;
                    lcounter++;
                }
                n = findNode(val);
                while(n.rightChild != null) {
                    n = n.rightChild;
                    rcounter++;
                }
            }

            //Different small conditions

            if(rcounter>lcounter)
                return rcounter;
            else if(lcounter>rcounter)
                return lcounter;
            else if(val == null || n == null)
                return -1;
            else if(rcounter == lcounter)
                return  rcounter;
            else if(n.rightChild == null || n.leftChild == null)
                return 0;



            return -2; // this line is here only so this code will compile if you don't modify it

        }




        // Method #4.
        protected boolean isBalanced(Node n) {

            /* IMPLEMENT THIS METHOD! */

            //Subtle test cases to be taken care

            if(n == null || findNode(n.value) == null)
                return false;

            if(n.leftChild == null || n.rightChild == null)
                return true; //because difference will be 0

            int left = height(n.leftChild.value);
            int right = height(n.rightChild.value);
            int h = Math.abs((left - right));

            if (h >= 0 && h <= 1)
                return true;


            return false; // this line is here only so this code will compile if you don't modify it

        }

        // Method #5. .
        public boolean isBalanced() {

            /* IMPLEMENT THIS METHOD! */


        return false;
        }


        private static Stack iterate(BinarySearchTree bst)
        {

            Stack<BinarySearchTree> nodes = new Stack<>();
            nodes.push(bst);
            while (!nodes.isEmpty()) {
                BinarySearchTree node = nodes.pop();
                if (node == null)
                    continue;
                else {
                    //System.out.println(node.node);
                   // nodes.push(node.rightChild);
                   // nodes.push(node.leftChild);
                }
            }
            return nodes;

        }


    }