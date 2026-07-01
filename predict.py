import pandas as pd
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt
import sys
import os

# Crop input

if len(sys.argv) > 1:

    crop = sys.argv[1]

else:

    crop = "tomato"

# Dataset path

base_path = os.path.dirname(
    __file__
)

file_path = os.path.join(

    base_path,

    "dataset",

    crop + ".csv"

)

# Read dataset

df = pd.read_csv(

    file_path

)

# Input and Output

X = df[['Day']]

y = df['Price']

# Model

model = LinearRegression()

model.fit(

    X,

    y

)

# Future prediction

future = model.predict(

    pd.DataFrame(

        [[20]],

        columns=['Day']

    )

)

# Output

print(

    int(

        future[0]

    )

)

# Graph

plt.figure(

    figsize=(8,5)

)

plt.plot(

    df['Day'],

    df['Price'],

    marker='o'

)

plt.title(

    crop.upper()

    +

    " PRICE TREND"

)

plt.xlabel(

    "Day"

)

plt.ylabel(

    "Price"

)

plt.grid()

plt.show()