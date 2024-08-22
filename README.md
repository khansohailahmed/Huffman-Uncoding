# Huffman-Uncoding
Q - Consider the following message aa bbbb a bbb ccc ddd eee ccc eee dd eee.

find the no of bits required for Huffman econding of above message also find the average bits required to represent a character

To find the number of bits required for Huffman encoding, we need to calculate the frequency of each character in the message and then build a Huffman tree.

## Answer - Here is the frequency of each character in the message:

a: 2
b: 4
c: 3
d: 3
e: 6
Next, we build a Huffman tree using the following steps:

Create a leaf node for each character with its frequency as the weight.
Sort the leaf nodes in ascending order of their weights.
Take the two nodes with the smallest weights and create a new internal node with a weight equal to the sum of the weights of the two nodes.
Repeat step 3 until only one node is left, which is the root of the Huffman tree.
Here is the Huffman tree for the given message:


Verify

Open In Editor
Edit
Copy code
        _______
       /        \
      /          \
     /            \
    /              \
   /                \
  a(2)              _______
                     /        \
                    /          \
                   /            \
                  /              \
                 b(4)            _______
                                  /        \
                                 /          \
                                /            \
                               /              \
                              c(3)            _______
                                               /        \
                                              /          \
                                             /            \
                                            /              \
                                           d(3)            e(6)
The Huffman codes for each character are:

a: 000
b: 01
c: 10
d: 110
e: 111
The total number of bits required to encode the message is:

2 (a) x 3 (bits per character) = 6 4 (b) x 2 (bits per character) = 8 3 (c) x 2 (bits per character) = 6 3 (d) x 3 (bits per character) = 9 6 (e) x 3 (bits per character) = 18

Total bits = 6 + 8 + 6 + 9 + 18 = 47

The average number of bits required to represent a character is:

47 (total bits) / 20 (total characters) = 2.35 bits per character
