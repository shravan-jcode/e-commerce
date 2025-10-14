import numpy as np

sigmoid = lambda x: 1/(1+np.exp(-x))
dsigmoid = lambda x: x*(1-x)

# Initialize weights
w1 = np.random.uniform(-1,1,(2,4))
w2 = np.random.uniform(-1,1,(4,1))

X = np.array([[0,0],[0,1],[1,0],[1,1]])
Y = np.array([[0],[1],[1],[0]])

# Train network
for _ in range(10000):
    for x,y in zip(X,Y):
        h = sigmoid(x.dot(w1))
        o = sigmoid(h.dot(w2))
        delta_o = (y-o)*dsigmoid(o)
        delta_h = delta_o.dot(w2.T)*dsigmoid(h)
        w2 += np.outer(h, delta_o)*0.1
        w1 += np.outer(x, delta_h)*0.1

# Predictions
for x in X:
    h = sigmoid(x.dot(w1))
    o = sigmoid(h.dot(w2))
    print(f"Input: {x}, Predicted: {o.round(3)}")
