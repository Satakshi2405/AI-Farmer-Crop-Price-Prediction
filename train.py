import pandas as pd
from sklearn.linear_model import LinearRegression
import joblib

df = pd.read_csv(
    "dataset/tomato.csv"
)

X = df[['Day']]
y = df['Price']

model = LinearRegression()

model.fit(X,y)

joblib.dump(
    model,
    "price_model.pkl"
)

print(
    "Model Saved Successfully"
)8